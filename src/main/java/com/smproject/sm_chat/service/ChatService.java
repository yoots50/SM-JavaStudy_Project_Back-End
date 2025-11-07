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
        // !!!!! 코드 작성하는 곳 !!!!!
        // 이곳에 message를 H2 데이터베이스에 저장하는 로직 구성
        // ChatRepository를 사용할 것, JpaRepository를 사용할 것
        // ChatEntity에 날짜를 넣어 DB에 넣을 것, 이때 날짜는 이곳에서 결정한다.
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
