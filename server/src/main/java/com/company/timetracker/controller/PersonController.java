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
import com.company.timetracker.domain.Shift;
import com.company.timetracker.service.PersonService;

/**
*  Open Port 4200 for Angular Frontend
*/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController{

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable String id){
        return personService.getPersonById(Long.parseLong(id));
    }

    @GetMapping("/persons/{id}/shifts")
    public List<Shift> getShiftsByPersonId(@PathVariable String id){
        Person person = personService.getPersonById(Long.parseLong(id));

        return person.getShiftList();
    }

    @GetMapping("/persons/{id}/shifts/latest")
    public Shift getActiveShiftByPersonId(@PathVariable String id){
        Person person = personService.getPersonById(Long.parseLong(id));
        List<Shift> shiftList = person.getShiftList();

        return shiftList.get(shiftList.size()-1);
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