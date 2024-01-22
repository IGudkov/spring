package ru.courses.innotech;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(value = 2)
@LogTransformation(logFileName = "checkTypeApplication.log")
public class CheckTypeApplication implements Intermediate {

  public List<FileLine> check(List<FileLine> fileLineList) {
    List<FileLine> retFileLineList = new ArrayList<>();
    for (FileLine fileLine : fileLineList) {
      String typeApplication = fileLine.getTypeApplication();
      if (!typeApplication.equals("web") && !typeApplication.equals("mobile")) {
        fileLine.setTypeApplication("other:" + typeApplication);
      }
      retFileLineList.add(fileLine);
    }
    return retFileLineList;
  }
}
