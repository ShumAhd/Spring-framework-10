package com.example.authservice.service;

import com.example.authservice.model.User;

/**
 * Сервис аутентификации.
 */
public interface AuthService {

  /**
   * Регистрирует нового пользователя.
   *
   * @param user данные нового пользователя
   */
  void register(User user);

  /**
   * Вход пользователя в систему.
   *
   * @param username имя пользователя
   * @param password пароль пользователя
   */
  void login(String username, String password);

  /**
   * Выход пользователя из системы.
   *
   * @param userId идентификатор пользователя
   */
  void logout(Long userId);

  /**
   * Получает текущего пользователя по идентификатору сессии.
   *
   * @param sessionId идентификатор сессии
   * @return текущий пользователь или null, если сессия не существует
   */
  User getCurrentUser(Long sessionId);
}
