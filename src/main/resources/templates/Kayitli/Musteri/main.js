
(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var name = $('.validate-input input[name="name"]');
    var email = $('.validate-input input[name="email"]');
    var message = $('.validate-input textarea[name="message"]');
    var roomId = 0;

    $('#btnStartConversation').click(function(){
        var check = true;

        if($(name).val().trim() == ''){
            showValidate(name);
            check=false;
        }


        if($(email).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
            showValidate(email);
            check=false;
        }
        if(check){
        	$("#login-frame").get(0).style.display="none";
        	$("#conv-frame").get(0).style.display="block";
            $('#customer_name')[0].innerHTML = $(name).val().trim();
        	startConversation();
        }
    });


    $('.validate-form .input1').each(function(){
        $(this).focus(function(){
           hideValidate(this);
       });
    });
    
    function startConversation(){
    	var location = window.location;
    	var wsUrl = 'wss://' + location.hostname + (location.port ? ':' + location.port : '') + '/customerConnector';
    	wsUrl += '?name='+$(name).val().trim()+'&email='+$(email).val().trim();
    	var wsCon = new WebSocket(wsUrl);
    	
    	wsCon.onopen = function() {
    		//wsCon.send("Message to send");
           // 
         };
			
         wsCon.onmessage = function (evt) { 
        	roomId = evt.data;
            $('#customer_image')[0].src = "../images/user"+roomId+".png";
            window.app.joinConversation(roomId);
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
setTimeout(function(){
	window.app.joinConversation(1);
}, 1000);
