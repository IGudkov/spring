package ru.courses.innotech;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileLine {
  private String fileName;
  private String login;
  private String surName;
  private String name;
  private String middleName;
  private String dateEntry;
  private String typeApplication;
}
