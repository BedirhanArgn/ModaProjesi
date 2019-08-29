var request = new XMLHttpRequest();

request.open('GET', '/api/getir/ProfilGoruntule?id=1', true);


request.onload = function () {
	// begin accessing JSON data here
	var data = JSON.parse(this.response);
	
	console.log(data.ad);


	$('#ad').val(data.ad);
	$('#email').val(data.email);
	$('#tel').val(data.telefon);
	$('#cinsiyet').val(data.cinsiyet);
	$('#boy').val(data.boy);
	$('#kilo').val(data.kilo);
	
	var dogumTarihi = new Date(data.dogumTarihi);
	$('#dogumTarihi').val(formatDate(dogumTarihi,'dd/MM/yyyy'));

	
};
request.send();

function degisiklikleri_kaydet(){

	var userObject={};
	userObject.id = 1;//FIXME 
	userObject.ad = $('#ad').val()
	userObject.boy=$('#boy').val()
	userObject.cinsiyet=$("#cinsiyet").val()
//	userObject.dogumTarihi=$('#dogumTarihi').val()
	userObject.email=$('#email').val()
	userObject.kilo=$('#kilo').val()
	userObject.telefon=$('#tel').val()
	

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

var monthNames = [
  "January", "February", "March", "April", "May", "June", "July",
  "August", "September", "October", "November", "December"
];
var dayOfWeekNames = [
  "Sunday", "Monday", "Tuesday",
  "Wednesday", "Thursday", "Friday", "Saturday"
];
function formatDate(date, patternStr){
    if (!patternStr) {
        patternStr = 'M/d/yyyy';
    }
    var day = date.getDate(),
        month = date.getMonth(),
        year = date.getFullYear(),
        hour = date.getHours(),
        minute = date.getMinutes(),
        second = date.getSeconds(),
        miliseconds = date.getMilliseconds(),
        h = hour % 12,
        hh = twoDigitPad(h),
        HH = twoDigitPad(hour),
        mm = twoDigitPad(minute),
        ss = twoDigitPad(second),
        aaa = hour < 12 ? 'AM' : 'PM',
        EEEE = dayOfWeekNames[date.getDay()],
        EEE = EEEE.substr(0, 3),
        dd = twoDigitPad(day),
        M = month + 1,
        MM = twoDigitPad(M),
        MMMM = monthNames[month],
        MMM = MMMM.substr(0, 3),
        yyyy = year + "",
        yy = yyyy.substr(2, 2)
    ;
    return patternStr
      .replace('hh', hh).replace('h', h)
      .replace('HH', HH).replace('H', hour)
      .replace('mm', mm).replace('m', minute)
      .replace('ss', ss).replace('s', second)
      .replace('S', miliseconds)
      .replace('dd', dd).replace('d', day)
      .replace('MMMM', MMMM).replace('MMM', MMM).replace('MM', MM).replace('M', M)
      .replace('EEEE', EEEE).replace('EEE', EEE)
      .replace('yyyy', yyyy)
      .replace('yy', yy)
      .replace('aaa', aaa)
    ;
}
function twoDigitPad(num) {
    return num < 10 ? "0" + num : num;
}




