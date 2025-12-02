package com.smproject.sm_chat.service;

import com.smproject.sm_chat.component.UserManager;
import com.smproject.sm_chat.dto.ChatDTO;
import com.smproject.sm_chat.entity.ChatEntity;
import com.smproject.sm_chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final UserManager userManager;
    private final ChatRepository chatRepository;

    public ChatDTO sendMessage(ChatDTO message){
        if (message.getType().equals(ChatDTO.messageType.ENTER)) {

            message.setMessage(message.getNickname() + "님이 입장하셨습니다.");
        }
        else if (message.getType().equals(ChatDTO.messageType.LEAVE)) {

            message.setMessage(message.getNickname() + "님이 퇴장하셨습니다.");
        } else {
            message.setMessage(message.getNickname() + ": " + message.getMessage());
        }
        ChatEntity chatEntity = ChatEntity.builder()
                .nickname(message.getNickname())
                .message(message.getMessage())
                .type(message.getType().name()) // Enum 타입이라면 name()으로 문자열 저장
                .build();

        chatRepository.save(chatEntity);
        return message;
    }

    public ArrayList<String> sendUsers(ChatDTO message) {
        if (message.getType().equals(ChatDTO.messageType.ENTER)) { // 유저로 부터 받은 메시지가 ENTER 메시지라면
            userManager.addUser(message.getNickname()); // 유저 리스트에 닉네임 추가

        }
        if (message.getType().equals(ChatDTO.messageType.LEAVE)) { // 유저로 부터 받은 메시지가 LEAVE 메시지라면
            userManager.deleteUser(message.getNickname()); // 유저 리스트에 닉네임 삭제
        }
        return userManager.getUserList(); // 유저 리스트 반환
    }
}
