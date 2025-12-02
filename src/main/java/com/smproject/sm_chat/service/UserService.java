package com.smproject.sm_chat.service;

import com.smproject.sm_chat.component.UserManager;
import com.smproject.sm_chat.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserManager userManager;
    public UserDTO nicknameService(UserDTO userDTO) {
        boolean isCopy = true; // 중복된 이름이 존재할 시 true
        int n = 0; // 유저 이름 뒤에 붙일 숫자

        String originalNickname = userDTO.getNickname();

        while (isCopy) {
            for (String u : userManager.getUserList()) {
                if (u.equals(userDTO.getNickname())) {
                    n++;
                }
            }
            if (n > 0) {
                userDTO.setNickname(originalNickname + "(" + n + ")");
            }
            isCopy = false;
        }
        return userDTO;
    }
}
