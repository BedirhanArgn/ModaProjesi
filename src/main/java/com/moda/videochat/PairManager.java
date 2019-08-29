package com.moda.videochat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PairManager {
	

	List<SessionPair> lstSessionPair = new ArrayList<>();
	
	Map<String, WebSocketSession> lstOnlineModacilar = new HashMap<>(); //Max number of stylish

	private int roomId = 1;
	
	private static final PairManager INSTANCE = new PairManager();
	
	public static PairManager getInstance() {
		return INSTANCE;
	}
	
	public void newCustomer(WebSocketSession customer) throws Exception{
		SessionPair sessionPair = new SessionPair();
		lstSessionPair.add(sessionPair);
		sessionPair.setClient(customer);
		String kullaniciId = (String) customer.getAttributes().get("kullanici_id");
		String modaciId = "1"; //TODO: (String) customer.getAttributes().get("modaci_id");
		sessionPair.setRoomId(roomId++);
		customer.sendMessage(new TextMessage(""+sessionPair.getRoomId()));
		WebSocketSession host = null;
		if((host = lstOnlineModacilar.get(modaciId)) != null) {
			sessionPair.setHost(host);
			ObjectMapper parser = new ObjectMapper();
			String json = parser.writeValueAsString(sessionPair);
			host.sendMessage(new TextMessage(json));
		}
	}
	
	public void newHost(WebSocketSession modaci) throws IOException {
		String modaciId = "1";//(String) modaci.getAttributes().get("modaci_id");
		lstOnlineModacilar.put(modaciId, modaci);
	}

	public void removeHost(WebSocketSession host) {
		lstOnlineModacilar.remove(host);
		for (SessionPair pair : lstSessionPair) {
			if(pair.getHost().equals(host)){
				pair.setHost(null);
			}
		}
	}

	public void removeCustomer(WebSocketSession customer) throws IOException {
		for (int i=0; i<lstSessionPair.size();i++) {
			SessionPair pair = lstSessionPair.get(i);
			if(pair.getClient().equals(customer)){
				pair.setActive(false);
				ObjectMapper parser = new ObjectMapper();
				String json = parser.writeValueAsString(pair);
				pair.getHost().sendMessage(new TextMessage(json));
				lstSessionPair.remove(i);
				break;
			}
		}
		
	}

	public void newMessageToStylish(WebSocketSession session, TextMessage message) throws IOException {
		for (int i=0; i<lstSessionPair.size();i++) {
			SessionPair pair = lstSessionPair.get(i);
			if(pair.getClient().equals(session)){
				pair.getHost().sendMessage(message);
				break;
			}
		}
	}

	public void newMessageToCustomer(WebSocketSession session, TextMessage message) throws IOException {
		for (int i=0; i<lstSessionPair.size();i++) {
			SessionPair pair = lstSessionPair.get(i);
			if(pair.getHost().equals(session)){
				pair.getClient().sendMessage(message);
				break;
			}
		}
		
	}
}
