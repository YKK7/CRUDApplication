package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method=RequestMethod.GET)
    public Iterable<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletePersonById(@PathVariable("id") int id){
        personService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertPerson(@RequestBody Person person){
        personService.insertPerson(person);
    }

}
