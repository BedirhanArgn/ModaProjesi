package com.moda.videochat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class StylishConnector extends TextWebSocketHandler {
	
	List<SessionPair> lstSessionPair = new ArrayList<>();
    
    @Autowired
    StylishConnector() {
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	PairManager.getInstance().newHost(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	PairManager.getInstance().newMessageToCustomer(session, message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	PairManager.getInstance().removeHost(session);
    }

}
