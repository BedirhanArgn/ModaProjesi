var request = new XMLHttpRequest();

request.open('GET', '/api/getir/modacilistesi', true);

request.onload = function(){
	// begin accessing JSON data here
	var data = JSON.parse(this.response);

	for (var i = 0; i < data.length; i++) {
		console.log(data[i].ad);
		
	
		$('#modaciListesi').append('<div class="col-md-6 col-sm-6">'+
                  '<div class="friend-card">'+
              
	                    ' <img src="/images/'+data[i].cinsiyet+'.png" alt="user" class="profile-photo-lg" />'+
	                     ' <div class="friend-info">'+
	                     ' <h5><a href="/ModaciAnasayfa.html?id='+data[i].id+'" class="profile-link">'+data[i].ad+'</a></h5>'+
	                    '  	<p>Modaci</p>'+
	                     ' </div>'+
	                  '  </div>'+
	                  '</div>'+
	               ' </div>');
	}
		
};
request.send();