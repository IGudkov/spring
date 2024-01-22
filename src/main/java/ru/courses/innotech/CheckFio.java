package ru.courses.innotech;

import org.apache.commons.text.WordUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(value = 1)
@LogTransformation(logFileName = "checkFIO.log")
public class CheckFio implements Intermediate {
  @Override
  public List<FileLine> check(List<FileLine> fileLineList){
    List<FileLine> retFileLineList = new ArrayList<>();
    for (FileLine fileLine : fileLineList) {
      fileLine.setSurName(WordUtils.capitalize(fileLine.getSurName()));
      fileLine.setName(WordUtils.capitalize(fileLine.getName()));
      fileLine.setMiddleName(WordUtils.capitalize(fileLine.getMiddleName()));
      retFileLineList.add(fileLine);
    }
    return retFileLineList;
  }
}
