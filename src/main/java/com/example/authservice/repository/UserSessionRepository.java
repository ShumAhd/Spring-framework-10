package com.example.authservice.repository;

import com.example.authservice.model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {

  void deleteByUserId(Long userId);
}
