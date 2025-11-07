package com.smproject.sm_chat.service;

import com.smproject.sm_chat.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserDTO nicknameService(UserDTO userDTO) {
        boolean isCopy = true;
        UserDTO returnDTO = userDTO;
        while (isCopy) {
            // 유저에게서 받은 닉네임과 중복된 닉네임이 현재 유저들의 닉네임 중에 있는지 확인하는 코드
            // 만약 중복된 닉네임이 없다면 isCopy를 false로 만듬
            // 만약 중복된 닉네임이 있다면 닉네임 뒤에 (1)을 붙이고 returnNickname을 nickname(1)로 바꿈
            // 다시 중복된 닉네임이 있는지 확인
            // 만약 중복된 닉네임이 있다면 닉네임 뒤에 (2)를 붙이고 ...반복
            // userDTO 안의 nickname을 사용하기 위해선 userDTO.getNickname()을 사용하면 됨
            // userDTO 안의 nickname을 다른 값으로 바꾸기 위해선 userDTO.setNickname(바꿀 값)을 사용하면 됨
            // 유저들의 닉네임 리스트는 userManager.getUserList()에서 얻을 수 있음
            isCopy = false;
        }
        return returnDTO;
    }
}
