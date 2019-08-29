var request = new XMLHttpRequest();

request.open('GET', '/api/getir/ProfilGoruntule?id=4', true);


request.onload = function () {
	// begin accessing JSON data here
	var data = JSON.parse(this.response);
	
	console.log(data.ad);
	$('#ad').append(data.ad);
};
request.send();