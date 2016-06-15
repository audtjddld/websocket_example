package com.websocket.hello.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.websocket.hello.Greeting;
import com.websocket.hello.HelloMessage;

@Controller
@MessageMapping("/hello")
public class GreetingController {
	
	@MessageMapping("send")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
		Thread.sleep(3000); // simulated delay
		Map<String, Object> attrs = headerAccessor.getSessionAttributes();
		System.out.println(attrs);
		return new Greeting(message.getName(), message.getMessage());
	}
	
	@MessageMapping("welcome")
	@SendTo("/topic/welcome")
	public Map welcomeMessage() throws Exception {
		Map resultMap = new HashMap();
		
		return (Map)resultMap.put("msg","손님이 접속했습니다."); 
	}
}
