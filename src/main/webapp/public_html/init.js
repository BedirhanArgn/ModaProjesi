$(".messages").animate({ scrollTop: $(document).height() }, "fast");

$("#profile-img").click(function() {
	$("#status-options").toggleClass("active");
});

$(".expand-button").click(function() {
  $("#profile").toggleClass("expanded");
	$("#contacts").toggleClass("expanded");
});

var userList = []
$("#status-options ul li").click(function() {
	$("#profile-img").removeClass();
	$("#status-online").removeClass("active");
	$("#status-away").removeClass("active");
	$("#status-busy").removeClass("active");
	$("#status-offline").removeClass("active");
	$(this).addClass("active");
	
	if($("#status-online").hasClass("active")) {
		$("#profile-img").addClass("online");
	} else if ($("#status-away").hasClass("active")) {
		$("#profile-img").addClass("away");
	} else if ($("#status-busy").hasClass("active")) {
		$("#profile-img").addClass("busy");
	} else if ($("#status-offline").hasClass("active")) {
		$("#profile-img").addClass("offline");
	} else {
		$("#profile-img").removeClass();
	};
	
	$("#status-options").removeClass("active");
});

function newMessage() {
	message = $(".message-input input").val();
	if($.trim(message) == '') {
		return false;
	}
	$('<li class="sent"><img src="../images/shoe.png" alt="" /><p>' + message + '</p></li>').appendTo($('.messages ul'));
	$('.message-input input').val(null);
	$('.contact.active .preview').html('<span>You: </span>' + message);
	$(".messages").animate({ scrollTop: $(document).height() }, "fast");
};

$('.submit').click(function() {
  newMessage();
});



$("#user_list").click(function(event) {
	
    var target = getEventTarget(event); //li
    var arr = target.id.split("_");
    var id = arr[1];
    window.app.leaveConversation(id);
    
    $('#customer_image')[0].src = "../images/user"+id+".png";
    $('#customer_name')[0].innerHTML = userList[id].customerName;
    setTimeout(function(){
    	window.app.joinConversation(id);
	}, 1000);
});

$(window).on('keydown', function(e) {
  if (e.which == 13) {
    newMessage();
    return false;
  }
});

getUserList();

function getEventTarget(e) {
    e = e || window.event;
    target  = e.target || e.srcElement;
    while(target.tagName != "LI"){
    	target = target.parentElement;
    }
    return target; 
}
function getUserList(){
	var location = window.location;
	var wsUrl = 'wss://' + location.hostname + (location.port ? ':' + location.port : '') + '/stylishConnector';
	var wsCon = new WebSocket(wsUrl);

	wsCon.onopen = function() {
	};

	wsCon.onmessage = function(evt) {
		var obj = JSON.parse(evt.data);
		if(obj.active){
			var strLi = '<li id="user_'+obj.roomId+'" class="contact animated tada">'+
							'<div class="wrap">'+
								'<span id="user_status_'+obj.roomId+'" class="contact-status online"></span>'+
								'<img src="../images/user'+obj.roomId+'.png" alt="" />'+
								'<div class="meta">'+
									'<p class="name">'+obj.customerName+'</p>'+
									'<p class="preview">'+obj.customerEMail+'</p>'+
								'</div>'+
							'</div>'+
						'</li>';
			$("#user_list").append(strLi);
			userList[obj.roomId] = obj;
		}
		else{
			$("#user_status_"+obj.roomId).removeClass("online").addClass("offline");
			$("#user_"+obj.roomId).addClass("flashit");
			setTimeout(function(){
				  $("#user_"+obj.roomId).remove();
				  userList[obj.roomId] = null;
			}, 3000);
		}
	};

	wsCon.onclose = function() {
	};
}



