package ru.courses.innotech;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.courses.innotech.entity.GinTestLogins;
import ru.courses.innotech.entity.GinTestUsers;
import ru.courses.innotech.repository.GinTestLoginsRepository;
import ru.courses.innotech.repository.GinTestUsersRepository;

import java.sql.Timestamp;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Writer {

  @Autowired
  private final GinTestUsersRepository ginTestUsersRepository;

  @Autowired
  private final GinTestLoginsRepository ginTestLoginsRepository;

  public void save2base(List<FileLine> fileLineList) {
    for (FileLine fileLine : fileLineList) {
      GinTestUsers ginTestUsers = ginTestUsersRepository.findByUsernane(fileLine.getLogin()).orElse(new GinTestUsers());
      ginTestUsers.setFio(fileLine.getSurName()+" "+
                          fileLine.getName()+" "+
                          fileLine.getMiddleName());
      ginTestUsers.setUsernane(fileLine.getLogin());
      ginTestUsersRepository.save(ginTestUsers);

      GinTestLogins ginTestLogins = new GinTestLogins();
      ginTestLogins.setUser(ginTestUsers);
      ginTestLogins.setAccessDate(Timestamp.valueOf(fileLine.getDateEntry().replace("T"," ")));
      ginTestLogins.setApplication(fileLine.getTypeApplication());
      ginTestLoginsRepository.save(ginTestLogins);
    }
  }

}
