package ru.courses.innotech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckTypeApplicationTest {

  @Test
  @DisplayName("Проверка типа приложения пройдена")
  public void checkTypeApplicationTrue() {
    FileLine fileLineIn = new FileLine();
    fileLineIn.setTypeApplication("mobile");
    List<FileLine> fileLineListIn = new ArrayList<>();
    fileLineListIn.add(fileLineIn);

    CheckTypeApplication checkTypeApplication = new CheckTypeApplication();
    List<FileLine> fileLineListOut = checkTypeApplication.check(fileLineListIn);
    Assertions.assertEquals(fileLineListOut.get(0).getTypeApplication(), "mobile");
  }

  @Test
  @DisplayName("Проверка типа приложения не пройдена, вначале строки добавляется \"other:\"")
  public void checkTypeApplicationFalse() {
    FileLine fileLineIn = new FileLine();
    fileLineIn.setTypeApplication("webmobile");
    List<FileLine> fileLineListIn = new ArrayList<>();
    fileLineListIn.add(fileLineIn);

    CheckTypeApplication checkTypeApplication = new CheckTypeApplication();
    List<FileLine> fileLineListOut = checkTypeApplication.check(fileLineListIn);
    Assertions.assertEquals(fileLineListOut.get(0).getTypeApplication(), "other:"+"webmobile");
  }

}
