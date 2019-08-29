package com.moda.videochat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class CustomerConnector extends TextWebSocketHandler {
	
	@Autowired
    CustomerConnector() {
    }
	
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	PairManager.getInstance().newCustomer(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	PairManager.getInstance().newMessageToStylish(session, message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	PairManager.getInstance().removeCustomer(session);
    }
    
    
}
