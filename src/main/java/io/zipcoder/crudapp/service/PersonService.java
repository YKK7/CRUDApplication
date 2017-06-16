package io.zipcoder.crudapp.service;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Person getPersonById(int id) {
        return personRepository.findOne(id);
    }

    public void delete(int id) {
        personRepository.delete(id);
    }

    public void updatePerson(Person person){
        Person p = personRepository.findOne(person.getId());
        p.setName(person.getName());
        p.setAge(person.getAge());
        personRepository.save(p);
    }

    public void insertPerson(Person person) {
        personRepository.save(person);
    }

    public boolean idExists(int id){
        return personRepository.exists(id);
    }
}
