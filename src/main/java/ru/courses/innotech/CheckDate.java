package ru.courses.innotech;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@Order(value = 3)
@LogTransformation(logFileName = "checkDate.log")
public class CheckDate implements Intermediate {

  @Override
  public List<FileLine> check(List<FileLine> fileLineList) {
    List<FileLine> retFileLineList = new ArrayList<>();
    for (FileLine fileLine : fileLineList) {
      if (fileLine.getDateEntry()==null || fileLine.getDateEntry().isEmpty()) {
        try {
          FileOutputStream fileOutputStream = new FileOutputStream("checkDateErr.log", true);
          fileOutputStream.write(("\n" + new Date() + " сheckDate.check: дата не заполнена: " + fileLine).getBytes(StandardCharsets.UTF_8));
          fileOutputStream.close();
        } catch (IOException e) {
          log.error("Ошибка записи в лог checkDateErr.log: "+e.getMessage());
        }
      }
      else {
        retFileLineList.add(fileLine);
      }
    }
    return retFileLineList;
  }
}
