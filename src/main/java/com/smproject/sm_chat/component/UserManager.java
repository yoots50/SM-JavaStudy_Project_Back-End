package com.smproject.sm_chat.component;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserManager {
    @Getter
    private static final ArrayList<String> userList = new ArrayList<>();

    public void addUser(String nickname) {
        userList.add(nickname);
    }

    public void deleteUser(String nickname) {
        userList.remove(nickname);
    }
}
