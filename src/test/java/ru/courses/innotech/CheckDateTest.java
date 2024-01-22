package ru.courses.innotech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckDateTest {

  @Test
  @DisplayName("Проверка даты не пройдена (дата не заполнена). Запись удаляется из массива")
  public void checkDateFalse() {
    FileLine fileLineIn = new FileLine();
    List<FileLine> fileLineListIn = new ArrayList<>();
    fileLineListIn.add(fileLineIn);

    CheckDate checkDate = new CheckDate();
    List<FileLine> fileLineListOut = checkDate.check(fileLineListIn);
    Assertions.assertTrue(fileLineListOut.isEmpty());
  }

  @Test
  @DisplayName("Проверка даты пройдена. Запись не удаляется из массива")
  public void checkDateTrue() {
    FileLine fileLineIn = new FileLine();
    fileLineIn.setDateEntry("2023-12-24T12:35:47");
    List<FileLine> fileLineListIn = new ArrayList<>();
    fileLineListIn.add(fileLineIn);

    CheckDate checkDate = new CheckDate();
    List<FileLine> fileLineListOut = checkDate.check(fileLineListIn);
    Assertions.assertFalse(fileLineListOut.isEmpty());
  }

}
