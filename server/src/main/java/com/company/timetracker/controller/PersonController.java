package com.company.timetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.timetracker.domain.Person;
import com.company.timetracker.service.PersonService;

/**
*  Open Port 4200 for Angular Frontend
*/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController{

    @Autowired
    private PersonService personService;

    @GetMapping("/getallpersons")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable String id){
        return personService.getPersonById(Long.parseLong(id));
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable String id){
        personService.deletePerson(Long.parseLong(id));
    }

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @PutMapping("/persons/{id}")
    public Person updatePerson(@PathVariable String id, @RequestBody Person person){
        return personService.updatePerson(person, Long.parseLong(id));
    }

}