package com.company.timetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.timetracker.domain.Person;
import com.company.timetracker.domain.PersonRepository;
import com.company.timetracker.exceptions.PersonNotFoundException;

@Component
public class PersonService{

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Person getPersonById(Long id)throws PersonNotFoundException{
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
    }

    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    public void deletePerson(Long id) throws PersonNotFoundException{
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException()); 
        personRepository.delete(person);
    }

    public Person updatePerson(Person person, Long id){
        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
        personRepository.deleteById(id);
        person.setId(id);
        
        return personRepository.save(person);
    }

}