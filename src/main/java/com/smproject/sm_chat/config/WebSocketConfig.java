package com.smproject.sm_chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // endpoint를 ws로 설정, 이곳에서 ws 서버와 연결이 이루어짐
                .setAllowedOriginPatterns("*")
                .withSockJS(); // SockJS를 사용하므로 이 메소드를 사용함
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // 이곳을 기준으로 구독이 이루어짐

        registry.setApplicationDestinationPrefixes("/app"); // 이곳을 기준으로 채팅 메시지나 유저 추가/삭제 요청 등을 받음
    }
}