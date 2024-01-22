package ru.courses.innotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "gin_test_users")
public class GinTestUsers {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id", nullable = false)
  private int id;

  @Column(name = "usernane", columnDefinition = "TEXT")
  private String usernane;

  @Column(name = "fio", columnDefinition = "TEXT")
  private String fio;
}
