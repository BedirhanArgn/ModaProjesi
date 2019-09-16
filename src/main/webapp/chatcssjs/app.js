var stompClient = null;
var username = null;
var stompClient = null;
var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];
$(document).ready(function(){
var messageInput=document.getElementById('message-to-send');
//var chatabout=document.querySelector('#chat-with');
var messagetosend = document.getElementById('sendmessage');
var chatabout=document.getElementById('chatname').textContent;
window.alert(chatabout);
connect(event);
function connect(event) {
    username = document.getElementById('chatname').textContent;
    if(username) {
        //usernamePage.classList.add('hidden');
        //chatPage.classList.remove('hidden');

        var socket = new SockJS('/moda');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}
function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);

    // Tell your username to the server
    stompClient.send("/app/chat.register",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )

    //connectingElement.classList.add('hidden');
}
function onError(error) {
    //connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    //connectingElement.style.color = 'red';
}
function send(event) {
    var messageContent = messageInput.value.trim();

    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };

        stompClient.send("/app/chat.send", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}

function sendMessage(event) {
	var messageContent=messageInput.value.trim();
	 if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}
function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        //var avatarElement = document.createElement('i');
        //var avatarText = document.createTextNode(message.sender[0]);
        //avatarElement.appendChild(avatarText);
        //avatarElement.style['background-color'] = getAvatarColor(message.sender);

 //       messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}
//chatabout.addEventListener('submit',connect,true);
messagetosend.addEventListener('submit', send, true);
})