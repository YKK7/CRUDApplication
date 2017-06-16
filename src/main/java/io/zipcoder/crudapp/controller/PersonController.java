package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.service.PersonService;
import io.zipcoder.crudapp.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPeople(){
        List<Person> people = new ArrayList<>();
        personService.getAllPeople().forEach(people::add);
        if(people.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Person>>(people, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonById(@PathVariable("id") int id) {
        Person person = personService.getPersonById(id);
        if(person == null){
            return new ResponseEntity(new CustomErrorType("Person with id = " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePersonById(@PathVariable("id") int id){
        if(!personService.idExists(id)){
            return new ResponseEntity(new CustomErrorType("Unable to delete. Person with id = " + id + " not found."), HttpStatus.NOT_FOUND);
        }
        personService.delete(id);
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(@RequestBody Person person){
        try {
            if (!personService.idExists(person.getId())) {
                return new ResponseEntity(new CustomErrorType("Unable to update. Person with id = " + person.getId() + " not found."), HttpStatus.NOT_FOUND);
            }
        } catch(NullPointerException npe){
            npe.getMessage();
        }
        personService.updatePerson(person);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insertPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
        try {
            if (personService.idExists(person.getId())) {
                return new ResponseEntity(new CustomErrorType("Unable to create. Person with id = " + person.getId() + " already Exists."), HttpStatus.CONFLICT);
            }
        } catch(NullPointerException npe){
            npe.getMessage();
        }
        personService.insertPerson(person);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/person/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

}
