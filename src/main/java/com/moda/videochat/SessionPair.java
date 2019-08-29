package com.moda.videochat;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Strings;

public class SessionPair {

	private int roomId;
	private String customerName;
	private String customerEMail;
	private boolean active = true;

	@JsonIgnore
	private WebSocketSession host;

	@JsonIgnore
	private WebSocketSession client;

	public WebSocketSession getHost() {
		return host;
	}

	public void setHost(WebSocketSession host) {
		this.host = host;
	}

	public WebSocketSession getClient() {
		return client;
	}

	public void setClient(WebSocketSession client) {
		this.client = client;
	}

	public Map<String, List<String>> splitQuery(String query) {
		if (Strings.isNullOrEmpty(query)) {
			return Collections.emptyMap();
		}
		return Arrays.stream(query.split("&")).map(this::splitQueryParameter)
				.collect(Collectors.groupingBy(SimpleImmutableEntry::getKey, LinkedHashMap::new,
						Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
	}

	public SimpleImmutableEntry<String, String> splitQueryParameter(String it) {
		final int idx = it.indexOf("=");
		final String key = idx > 0 ? it.substring(0, idx) : it;
		final String value = idx > 0 && it.length() > idx + 1 ? it.substring(idx + 1) : null;
		return new SimpleImmutableEntry<>(key, value);
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getCustomerEMail() {
		return customerEMail;
	}

	public void setCustomerEMail(String customerEMail) {
		this.customerEMail = customerEMail;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
