package com.smproject.sm_chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ChatDTO {
    public enum messageType {
        ENTER,
        LEAVE,
        MESSAGE,
    }
    private messageType type;
    private String message;
    private String nickname;
    private String date;
}
