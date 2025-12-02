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
        UserDTO returnDTO = userDTO; // 사용자에게 보낼 닉네임이 담긴 객체
        int n = 0; // 유저 이름 뒤에 붙일 숫자

        String originalNickname = userDTO.getNickname();

        while (isCopy) {
            // !!!!! 코드 작성하는 곳 !!!!!
            // 유저에게서 받은 닉네임과 중복된 닉네임이 현재 유저들의 닉네임 중에 있는지 확인하는 코드
            isCopy = false;
            for (UserDTO u : userManager.getUserList()) {
                if (u.getNickname().equals(returnDTO.getNickname())) {
                    isCopy = true;
                    n++;
                    returnDTO.setNickname(originalNickname + "(" + n + ")");
                    break;
                }
            }
        }
        return returnDTO;
    }
}
