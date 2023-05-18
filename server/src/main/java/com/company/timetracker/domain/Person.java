package com.company.timetracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    
    @Id
    @GeneratedValue
    @JsonProperty(access = Access.READ_ONLY)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany
    private List<Shift> shiftList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<Shift> getShiftList() {
        return shiftList;
    }

    public void addToShiftList(Shift shift) {
        shiftList.add(shift);
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
