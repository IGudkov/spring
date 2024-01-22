package ru.courses.innotech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReaderTest {

  @Test
  @DisplayName("Ошибка чтения данных, если параметр с каталогом для обработки файлов не указан ")
  public void filePathNull() {
    Reader reader = new Reader();
    Assertions.assertThrows(NullPointerException.class, () -> reader.readDataFromFiles(null));
  }

  @Test
  @DisplayName("Ошибка чтения данных, если в параметре с каталогом указан несуществующий путь")
  public void filePathNotExist() {
    Reader reader = new Reader();
    Assertions.assertThrows(NullPointerException.class, () -> reader.readDataFromFiles("test/qwe"));
  }

  @Test
  @DisplayName("В параметре с каталогом указан существующий путь, но файлы для обработки отсутствуют")
  public void filePathExistAndFilesNotExists() {
    Reader reader = new Reader();
    List<FileLine> fileLineList = reader.readDataFromFiles("src/test/resources/files2");
    Assertions.assertTrue(fileLineList.isEmpty());
  }

  @Test
  @DisplayName("В параметре с каталогом указан существующий путь, файлы для обработки есть")
  public void filePathExistAndFilesExists() {
    Reader reader = new Reader();
    List<FileLine> fileLineList = reader.readDataFromFiles("src/test/resources/files");
    Assertions.assertFalse(fileLineList.isEmpty());
  }

}
