package com.smproject.sm_chat.service;

import com.smproject.sm_chat.dto.ChatDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
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
}
