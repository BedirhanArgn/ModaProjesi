var request = new XMLHttpRequest();

request.open('GET', '/api/getir/ProfilGoruntule?id=1', true);


request.onload = function () {
	// begin accessing JSON data here
	var data = JSON.parse(this.response);
	
	console.log(data.sifre);
	$('#my-password').val(data.sifre);

	
};
request.send();

function parola_guncelle(){

	var userObject={};
	userObject.id = 1;//FIXME 
	userObject.sifre =$('#new-password').val()
	

	var text = JSON.stringify(userObject);

	var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
	    if (xhttp.readyState == 4) {
	    	 var result = $.parseJSON(this.response); 

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
  
    xhttp.open("POST", "/api/guncelle/musteri",true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("X-Atlassian-Token", "nocheck");
    xhttp.setRequestHeader('Authorization', 'Basic'+btoa('username:password')); 
    xhttp.send(text);
    
    
}





