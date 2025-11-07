package com.smproject.sm_chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // !!!!! 코드 작성하는 곳 !!!!!
    // Repository와 DB가 소통할 때 쓰이는 ChatEntity 구성, ChatDTO를 참고할 것, 날짜를 추가할 것
}
