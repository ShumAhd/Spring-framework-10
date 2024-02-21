package com.example.authservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class UserSession  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long userId;
  private String username;
  private String password;

  public void setLoggedInAt(LocalDateTime now) {
  }
}
