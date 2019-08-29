package com.moda.videochat;

import org.nextrtc.signalingserver.NextRTCConfig;
import org.nextrtc.signalingserver.api.NextRTCServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@Import(NextRTCConfig.class)
public class MyWebSocketConfigurator implements WebSocketConfigurer {
    @Autowired
    private NextRTCServer server;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(customEndpoint(), "/signaling").setAllowedOrigins("*");
        registry.addHandler(customerEndPoint(), "/customerConnector").setAllowedOrigins("*");
        registry.addHandler(stylishEndpoint(), "/stylishConnector").setAllowedOrigins("*");
    }

    @Bean
    public MyEndpoint customEndpoint() {
        return new MyEndpoint(server);
    }
    
    @Bean
    public StylishConnector stylishEndpoint() {
    	return new StylishConnector();
    }
    @Bean
    public CustomerConnector customerEndPoint() {
    	return new CustomerConnector();
    }
}