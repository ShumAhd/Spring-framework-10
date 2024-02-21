package com.example.authservice.service;

import com.example.authservice.model.User;
import com.example.authservice.model.UserSession;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.repository.UserSessionRepository;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserSessionRepository userSessionRepository;

  @Autowired
  public AuthServiceImpl(UserRepository userRepository, UserSessionRepository userSessionRepository) {
    this.userRepository = userRepository;
    this.userSessionRepository = userSessionRepository;
  }

  @Override
  public void register(User user) {
    userRepository.save(user);
    logger.info("Registered new user with username: {}", user.getUsername());
  }

  @Override
  public void login(String username, String password) {
    User user = userRepository.findByUsername(username);
    if (user != null && user.getPassword().equals(password)) {
      UserSession session = new UserSession();
      session.setUserId(user.getId());
      session.setLoggedInAt(LocalDateTime.now());
      userSessionRepository.save(session);
      System.out.println("User logged in: " + user.getUsername());
    } else {
      System.out.println("Invalid username or password");
    }
  }

  @Override
  public void logout(Long userId) {
    // Логика выхода пользователя
  }

  @Override
  public User getCurrentUser(Long sessionId) {
    UserSession userSession = userSessionRepository.findById(sessionId).orElse(null);
    if (userSession != null) {
      // Предполагается, что у сессии есть поле с идентификатором пользователя
      return userRepository.findById(userSession.getUserId()).orElse(null);
    }
    return null;
  }
}
