package ru.courses.innotech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckFioTest {

  @Test
  @DisplayName("Проверка перевода ФИО в слова с заглавной буквы")
  public void checkСapitalize() {
    FileLine fileLineIn = new FileLine();
    fileLineIn.setSurName("иванов");
    fileLineIn.setName("иван");
    fileLineIn.setMiddleName("иванович");
    List<FileLine> fileLineListIn = new ArrayList<>();
    fileLineListIn.add(fileLineIn);

    CheckFio checkFio = new CheckFio();
    List<FileLine> fileLineListOut = checkFio.check(fileLineListIn);
    FileLine fileLineOut = fileLineListOut.get(0);

    Assertions.assertAll(
        () -> Assertions.assertEquals(fileLineOut.getSurName(), fileLineOut.getSurName().substring(0,1).toUpperCase() + fileLineOut.getSurName().substring(1)),
        () -> Assertions.assertEquals(fileLineOut.getName(), fileLineOut.getName().substring(0,1).toUpperCase() + fileLineOut.getName().substring(1)),
        () -> Assertions.assertEquals(fileLineOut.getMiddleName(), fileLineOut.getMiddleName().substring(0,1).toUpperCase() + fileLineOut.getMiddleName().substring(1))
    );

  }

}
