package ru.courses.innotech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.courses.innotech.entity.GinTestUsers;

import java.util.Optional;

@Repository
public interface GinTestUsersRepository extends CrudRepository<GinTestUsers,Integer> {
  Optional<GinTestUsers> findByUsernane(String username);
}
