package com.smproject.sm_chat.controller;

import com.smproject.sm_chat.dto.ChatDTO;
import com.smproject.sm_chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatDTO sendMessage(ChatDTO message){
        ChatDTO returnMessage = chatService.sendMessage(message);
        System.out.println(returnMessage);
        return returnMessage;
    }

    @MessageMapping("/send")
    @SendTo("/topic/users")
    public ArrayList<String> sendUsers(ChatDTO message){
        return chatService.sendUsers(message);
    }
}
