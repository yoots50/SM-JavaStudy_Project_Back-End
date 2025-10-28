package com.smproject.sm_chat.service;

import com.smproject.sm_chat.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserDTO nicknameService(UserDTO userDTO) {
        Boolean isCopy = true;
        UserDTO returnDTO = userDTO;
        while (isCopy) {
            // 유저에게서 받은 닉네임과 중복된 닉네임이 DB에 있는지 확인하는 코드
            // 만약 중복된 닉네임이 없다면 isCopy를 false로 만듬
            // 만약 중복된 닉네임이 있다면 닉네임 뒤에 (1)을 붙이고 returnNickname을 nickname(1)로 바꿈
            // 다시 DB에 중복된 닉네임이 있는지 확인
            // 만약 중복된 닉네임이 있다면 닉네임 뒤에 (2)를 붙이고 ...반복
            // H2 데이터베이스를 사용할 것, JpaRepository, UserRepository를 사용할 것
            // userDTO 안의 nickname을 사용하기 위해선 userDTO.getNickname()을 사용할 것
            // userDTO 안의 nickname을 다른 값으로 바꾸기 위해선 userDTO.setNickname(바꿀 값)을 사용할 것
            isCopy = false;
        }
        return returnDTO;
    }
}
