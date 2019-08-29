
function kayit_ol(){
	var userObject={};
	userObject.ad = $('#firstname').val()
	userObject.email=$('#email').val()
	userObject.sifre=$('#password').val()
	userObject.dogum_tarihi=$("#bday").val()
	userObject.kilo=$('#kilo').val()
	userObject.boy=$('#boy').val()
	userObject.telefon=$("#telefon").val()
	userObject.cinsiyet=$("input[type='radio']").val();

	var text = JSON.stringify(userObject);
	console.log(text);
	
	var obj = JSON.parse(text);
	console.log(obj.email);
	
	var xhttp = new XMLHttpRequest();
   
    xhttp.onreadystatechange = function() {
	    if (xhttp.readyState == 4) {
	    	 var result =  $.parseJSON(this.response);
             $('.tab-pane a[href="#login"]').tab('show');

	          var str = '';
	          if(result == 1) {
	            str = 'User record saved successfully.';

	          }else if( result == 2) {
	            str == 'All fields are required.';
	          } else{
	            str = 'User data could not be saved. Please try again'; 
	          }
	        $("#message").css('color', 'red').html(str);
	    }
    };
  
    xhttp.open("POST", "api/kaydet/kullanici",true);

    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("X-Atlassian-Token", "nocheck");
    xhttp.setRequestHeader('Authorization', 'Basic'+btoa('username:password')); 
    xhttp.send(text);
	
}