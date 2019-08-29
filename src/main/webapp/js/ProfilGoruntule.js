var request = new XMLHttpRequest();

request.open('GET', '/api/getir/ProfilGoruntule?id=1', true);


request.onload = function () {
	// begin accessing JSON data here
	var data = JSON.parse(this.response);
	
	console.log(data.ad);
	console.log(data.dogumTarihi.slice(0,10));
	$('#ad').append(data.ad);
	$('#boy').append(data.boy);
	$('#cinsiyet').append(data.cinsiyet);
	$('#email').append(data.email);
	$('#kilo').append(data.kilo);
	$('#telefon').append(data.telefon);
	$('#dogumTarihi').append(data.dogumTarihi.slice(0,10));
   
};
request.send();

