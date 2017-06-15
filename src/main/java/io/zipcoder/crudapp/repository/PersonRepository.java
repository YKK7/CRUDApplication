package io.zipcoder.crudapp.repository;

import io.zipcoder.crudapp.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
}
