package com.smproject.sm_chat.repository;

import com.smproject.sm_chat.entity.UserEntity;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,Long> {
    // nickname을 DB에서 찾을 수 있는 로직 작성
}
