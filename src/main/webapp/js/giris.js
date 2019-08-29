function giris_yap(){
	var girisObject={};
	
	girisObject.email=$('#my-email').val()
	girisObject.sifre=$('#my-password').val()

	var text = JSON.stringify(girisObject);
/*
	var xhttp = new XMLHttpRequest();

	    xhttp.onreadystatechange = function() {
    	    if (xhttp.readyState == 4) {
    	    	 var result =  $.parseJSON(this.response);

    	          var str = '';
    	          if(result == 1) {
    	            str = 'User record saved successfully.';
                       window.show(str);
    	          }else if( result == 2) {
    	            str == 'All fields are required.';
    	                                   window.show(str);

    	          } else{
    	            str = 'User data could not be saved. Please try again';
    	                                   window.show(str);

    	          }
    	        $("#message").css('color', 'red').html(str);
    	    }
        };

	 xhttp.open("POST", "/login",true);

        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.setRequestHeader("X-Atlassian-Token", "nocheck");
        xhttp.setRequestHeader('Authorization', 'Basic'+btoa('username:password'));
        xhttp.send(text);


*/

            $.ajax({
                   url: '/login',
                   async:false,
                   method: 'POST',
                   dataType: 'json',
                   data: text,
                   contentType : "application/json",

            });





}
