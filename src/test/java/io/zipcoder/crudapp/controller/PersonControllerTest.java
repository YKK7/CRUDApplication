package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.CRUDApplication;
import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import io.zipcoder.crudapp.service.PersonService;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CRUDApplication.class)
//@TestPropertySource(locations = {"classpath:application.properties", "classpath:application-h2.properties"}, properties = {"javax.persistence.sql-load-script-source=classpath:data-h2.sql", "javax.persistence.schema-generation.create-script-source=classpath:schema-h2.sql"})
public class PersonControllerTest {

    @Autowired
    PersonController personController;

    @Autowired
    PersonRepository personRepository;


//    @BeforeClass
//    public static void init(){
//
//    }


    @Test
    public void getAllPeopleTest(){
        //Given
        String expectedName1 = "Brian Mullin";
        String expectedName2 = "Stephen Pegram";
        int expectedId1 = 1;
        int expectedId2 = 2;
        int expectedAge1 = 24;
        int expectedAge2 = 25;

        Person person1 = new Person(expectedName1, expectedAge1);
        Person person2 = new Person(expectedName2, expectedAge2);
        personRepository.save(person1);
        personRepository.save(person2);


        //When
        List<Person> list = personController.getAllPeople().getBody();
        String actualName1 = list.get(0).getName();
        String actualName2 = list.get(1).getName();
        int actualAge1 = list.get(0).getAge();
        int actualAge2 = list.get(1).getAge();
        int actualId1 = list.get(0).getId();
        int actualId2 = list.get(1).getId();

        //Then
        assertEquals(expectedName1, actualName1);
        assertEquals(expectedName2, actualName2);
        assertEquals(expectedAge1, actualAge1);
        assertEquals(expectedAge2, actualAge2);
        assertEquals(expectedId1, actualId1);
        assertEquals(expectedId2, actualId2);

    }
}
