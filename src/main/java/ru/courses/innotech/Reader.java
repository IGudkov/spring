package ru.courses.innotech;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Component
public class Reader {
  public List<FileLine> readDataFromFiles(String folderPath) {

    File folder = new File(folderPath);
    List<FileLine> fileLineList = new ArrayList<>();

    for (File file : Objects.requireNonNull(folder.listFiles())) {
      if (file.isFile()) {
        try {
          Scanner scanner = new Scanner(file);
          while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String [] words = s.split(" ");
            FileLine fileLine = getFileLine(file, words);
            fileLineList.add(fileLine);
          }
        } catch (FileNotFoundException ignored) { }
      }
    }
    return fileLineList;
  }

  private static FileLine getFileLine(File file, String[] words) {
    FileLine fileLine = new FileLine();
    fileLine.setFileName(file.getName());
    for (int i = 0; i < words.length; i++) {
      switch (i) {
        case (0):
          fileLine.setLogin(words[i]);
          break;
        case (1):
          fileLine.setSurName(words[i]);
          break;
        case (2):
          fileLine.setName(words[i]);
          break;
        case (3):
          fileLine.setMiddleName(words[i]);
          break;
        case (4):
          fileLine.setDateEntry(words[i]);
          break;
        case (5):
          fileLine.setTypeApplication(words[i]);
          break;
      }
    }
    return fileLine;
  }

}
