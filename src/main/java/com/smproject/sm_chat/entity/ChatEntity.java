package com.smproject.sm_chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String message;
    private String nickname;
    private String date;

    public ChatEntity() {}

    public ChatEntity(String type, String message, String nickname, String date) {
        this.type = type;
        this.message = message;
        this.nickname = nickname;
        this.date = date;
    }

}
