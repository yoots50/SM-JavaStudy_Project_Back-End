package com.smproject.sm_chat.repository;

import com.smproject.sm_chat.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatEntity, String> {
}
