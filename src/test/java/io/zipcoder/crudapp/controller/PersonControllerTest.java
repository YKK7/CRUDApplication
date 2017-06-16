package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.CRUDApplication;
import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import io.zipcoder.crudapp.service.PersonService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CRUDApplication.class)
public class PersonControllerTest {

    @Autowired
    PersonController personController;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void getAllPeopleTest(){
        //Given
        List<Person> list = new ArrayList<Person>();
        Person person1 = new Person("Brian Mullin", 24);
        Person person2 = new Person("Stephen Pegram", 25);
        list.add(person1);
        list.add(person2);
        ResponseEntity<List<Person>> expected = new ResponseEntity<List<Person>>(list, HttpStatus.OK);
        personRepository.save(person1);
        personRepository.save(person2);


        //When
        ResponseEntity<List<Person>> actual = personController.getAllPeople();

        //Then
        assertEquals("getAllPeople should return the three Person objects that were pre-loaded into the H2 database using data-h2.sql",expected, actual);
    }
}
