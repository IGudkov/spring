package ru.courses.innotech.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "gin_test_logins")
public class GinTestLogins {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id", nullable = false)
  private int id;

  @Column(name = "access_date")
  private Timestamp accessDate;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private GinTestUsers user;

  @Column(name = "application", columnDefinition = "TEXT")
  private String application;
}
