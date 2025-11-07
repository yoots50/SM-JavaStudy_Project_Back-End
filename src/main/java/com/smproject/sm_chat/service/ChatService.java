package com.smproject.sm_chat.service;

import com.smproject.sm_chat.component.UserManager;
import com.smproject.sm_chat.dto.ChatDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final UserManager userManager;

    public ChatDTO sendMessage(ChatDTO message){
        if (message.getType().equals(ChatDTO.messageType.ENTER)) {

            message.setMessage(message.getNickname() + "님이 입장하셨습니다.");
        }
        else if (message.getType().equals(ChatDTO.messageType.LEAVE)) {

            message.setMessage(message.getNickname() + "님이 퇴장하셨습니다.");
        } else {
            message.setMessage(message.getNickname() + ": " + message.getMessage());
        }
        // 이곳에 message를 H2 데이터베이스에 저장하는 로직 구성
        // ChatRepository를 사용할 것, JpaRepository를 사용할 것
        return message;
    }

    public ArrayList<String> sendUsers(ChatDTO message) {
        if (message.getType().equals(ChatDTO.messageType.ENTER)) {
            userManager.addUser(message.getNickname());

        }
        if (message.getType().equals(ChatDTO.messageType.LEAVE)) {
            userManager.deleteUser(message.getNickname());
        }
        return userManager.getUserList();
    }
}
