
(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/

    $('#btnGonder').click(function(){
     	startConversation();
    });


    $('.validate-form .input1').each(function(){
        $(this).focus(function(){
           hideValidate(this);
       });
    });
    
    function startConversation(){
	    
	    var xhr = new XMLHttpRequest();
		var url = "http://localhost:8080/api/kaydet/mesaj";
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.onreadystatechange = function () {
		    if (xhr.readyState === 4 && xhr.status === 200) {
		        var json = JSON.parse(xhr.responseText);
		        console.log(json.email + ", " + json.password);
		    }
		};
		
		var mesaj={};
		mesaj.mesaj = $('.validate-input textarea[name="mesaj"]').value;
	
		var data = JSON.stringify(mesaj);
		xhr.send(data);


    	wsCon.onopen = function() {
    		wsCon.send(message);
         };
			
         wsCon.onmessage = function (evt) { 
        	roomId = evt.data;
            //$('#customer_image')[0].src = "../images/user"+roomId+".png";
           // window.app.joinConversation(roomId);
         };
			
         wsCon.onclose = function() { 
        	
         };
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    $(".messages").animate({ scrollTop: $(document).height() }, "fast");

    function newMessage() {
    	message = $(".message-input input").val();
    	if($.trim(message) == '') {
    		return false;
    	}
    	$('<li class="sent"><img src="../images/user'+roomId+'.png" alt="" /><p>' + message + '</p></li>').appendTo($('.messages ul'));
    	$('.message-input input').val(null);
    	$('.contact.active .preview').html('<span>You: </span>' + message);
    	$(".messages").animate({ scrollTop: $(document).height() }, "fast");
    };

    $('.submit').click(function() {
      newMessage();
    });



    $(window).on('keydown', function(e) {
      if (e.which == 13) {
        newMessage();
        return false;
      }
    });

})(jQuery);

