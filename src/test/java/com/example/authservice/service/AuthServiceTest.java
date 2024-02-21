package com.example.authservice.service;

import com.example.authservice.model.User;
import com.example.authservice.repository.UserSessionRepository; // Импортируем правильный репозиторий
import com.example.authservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserSessionRepository userSessionRepository; // Используем правильное имя репозитория

  @InjectMocks
  private AuthServiceImpl authService;

  @Test
  public void testRegister() {
    User user = new User();
    authService.register(user);
    verify(userRepository).save(user);
  }


}
