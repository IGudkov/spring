package ru.courses.innotech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import ru.courses.innotech.repository.GinTestLoginsRepository;
import ru.courses.innotech.repository.GinTestUsersRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ApplicationContextTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Mock
  GinTestLoginsRepository ginTestLoginsRepository;

  @Mock
  GinTestUsersRepository ginTestUsersRepository;

  @Mock
  Writer writer;

  @Test
  @DisplayName("Проверка бинов и зависимостей")
  void checkApplicationContextBeans() {
    Assertions.assertDoesNotThrow(() -> applicationContext.getBean(Executor.class), "Бин не создан");
    Executor executor = applicationContext.getBean(Executor.class);
    Assertions.assertAll("Проверка зависимостей",
        () -> assertNotNull(executor.getReader(), "reader is null"),
        () -> assertNotNull(executor.getIntermediateList(), "intermediateList is null"),
        () -> assertNotNull(executor.getWriter(), "writer is null")
        );
  }

  @Test
  @DisplayName("Проверка работы приложения с установленной заглушкой на бин записи в БД ")
  void checkExecutor() {
    Reader reader = new Reader();
    List<Intermediate> intermediateList = applicationContext.getBeansOfType(Intermediate.class).values().stream().toList();
    Mockito.doNothing().when(writer).save2base(Mockito.any());

    Executor executor = new Executor(reader,intermediateList,writer);
    Assertions.assertDoesNotThrow(() -> executor.run("src/test/resources/files"));
  }

}
