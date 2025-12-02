package com.smproject.sm_chat.service;

import com.smproject.sm_chat.component.UserManager;
import com.smproject.sm_chat.dto.ChatDTO;
import com.smproject.sm_chat.entity.ChatEntity;
import com.smproject.sm_chat.repository.ChatRepository;
import java.text.SimpleDateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final UserManager userManager;
    private final ChatRepository chatRepository;

    public ChatDTO sendMessage(ChatDTO message){
        Date date = new Date();
        SimpleDateFormat formatMethod = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
        String strDate = formatMethod.format(date);
        ChatEntity chatEntity = ChatEntity.builder()
                .nickname(message.getNickname())
                .message(message.getMessage())
                .type(message.getType().name()).date(strDate)
                .build();
        System.out.println(chatEntity);
        chatRepository.save(chatEntity);
        message.setDate(strDate);
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
