package com.smproject.sm_chat.controller;

import com.smproject.sm_chat.dto.AuthDTO;
import com.smproject.sm_chat.dto.UserDTO;
import com.smproject.sm_chat.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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
        System.out.println(request.getId() + " " + request.getPw());
        JSONObject response = userService.getData(request, "/UsrSchMng/selectStdInfo.do");
        return AuthDTO.from(response.getJSONArray("dsStdInfoList"));
    }
}
