package com.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer  {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		// registerStompEndpoints() 메소드는 /hello를 endpoint로 등록되었다.
		// SockJS는 Websocket을 사용할 수 없을 때 메시징 옵션을 보안책으로 해준다.
		registry.addEndpoint("/hello/webcome","/hello/send").withSockJS();
				//.withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		
		// 단순 메모리 기반 메시지 브로커는 greeting message를 topic이라는 prefix를 가진 client한테로 전달해준다.
		config.setApplicationDestinationPrefixes("/app");
		config.enableSimpleBroker("/topic", "/queue");
	}
}
