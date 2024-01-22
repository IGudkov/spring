package ru.courses.innotech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.courses.innotech.entity.GinTestLogins;

@Repository
public interface GinTestLoginsRepository extends CrudRepository<GinTestLogins,Integer> {
}
