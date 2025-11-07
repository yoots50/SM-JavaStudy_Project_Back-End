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
        while (isCopy) {
            // !!!!! 코드 작성하는 곳 !!!!!
            // 유저에게서 받은 닉네임과 중복된 닉네임이 현재 유저들의 닉네임 중에 있는지 확인하는 코드
            isCopy = false; // 만약 중복된 닉네임이 없다면 isCopy를 false로 만듬
            // 만약 중복된 닉네임이 있다면 n = n + 1을 수행하고 닉네임 뒤에 (n)을 붙인 뒤 returnNickname을 nickname(n)로 바꿈
            // 다시 중복된 닉네임이 있는지 확인
            // 만약 중복된 닉네임이 있다면 n = n + 1을 수행하고 닉네임 뒤에 (n)를 붙인 뒤 ...반복
            // userDTO 안의 nickname을 사용하기 위해선 userDTO.getNickname()을 사용하면 됨
            // userDTO 안의 nickname을 다른 값으로 바꾸기 위해선 userDTO.setNickname(바꿀 값)을 사용하면 됨
            // 유저들의 닉네임 리스트는 userManager.getUserList()에서 얻을 수 있음
        }
        return returnDTO;
    }
}
