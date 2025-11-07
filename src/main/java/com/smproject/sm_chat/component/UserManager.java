package com.smproject.sm_chat.component;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserManager {
    @Getter
    private static final ArrayList<String> userList = new ArrayList<>();

    public void addUser(String nickname) {
        if (!userList.contains(nickname)) { // userList에 해당하는 닉네임이 없다면
            userList.add(nickname); // 닉네임을 userList에 추가
        };
    }

    public void deleteUser(String nickname) {
        userList.remove(nickname); // 닉네임을 userList에서 삭제
    }
}
