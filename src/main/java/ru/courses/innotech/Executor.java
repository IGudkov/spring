package ru.courses.innotech;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Getter
@Setter
public class Executor {

  private final Reader reader;
  private final List<Intermediate> intermediateList;
  private final Writer writer;

  public void run(String folderPath) {
    try {
      List<FileLine> fileLineList = reader.readDataFromFiles(folderPath);
      if (!fileLineList.isEmpty()) {
        for (Intermediate intermediate : intermediateList) {
          fileLineList = intermediate.check(fileLineList);
        }
        writer.save2base(fileLineList);
      }
    } catch (Exception e) {
      log.error("Error: ", e);
      throw new RuntimeException("Error: ", e);
    }
  }

}
