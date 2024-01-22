package ru.courses.innotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StarterApplication {
  public static void main(String[] args)  {
    ApplicationContext applicationContext = SpringApplication.run(StarterApplication.class, args);

    Executor executor = applicationContext.getBean(Executor.class);
    executor.run("src/main/resources/files");
  }
}