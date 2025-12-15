package com.smproject.sm_chat.controller;

import com.smproject.sm_chat.dto.AuthDTO;
import com.smproject.sm_chat.dto.UserDTO;
import com.smproject.sm_chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/auth")
    public AuthDTO auth(UserDTO request) {
        JSONObject response = userService.getData(request, "/UsrSchMng/selectStdInfo.do");
        return AuthDTO.from(response.getJSONArray("dsStdInfoList"));
    }
}
