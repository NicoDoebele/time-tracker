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

import com.company.timetracker.domain.Shift;
import com.company.timetracker.service.ShiftService;

/**
*  Open Port 4200 for Angular Frontend
*/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ShiftController{

    @Autowired
    private ShiftService shiftService;

    @GetMapping("/shifts")
    public List<Shift> getAllShifts(){
        return shiftService.getAllshifts();
    }

    @GetMapping("/shifts/{id}")
    public Shift getPersonById(@PathVariable String id){
        return shiftService.getShiftById(Long.parseLong(id));
    }

    @DeleteMapping("/shifts/{id}")
    public void deletePerson(@PathVariable String id){
        shiftService.deleteShift(Long.parseLong(id));
    }

    @PostMapping("/shifts")
    public Shift addShifts(@RequestBody Shift shift){
        return shiftService.addShift(shift);
    }

    @PutMapping("/shifts/{id}")
    public Shift updatePerson(@PathVariable String id, @RequestBody Shift shift){
        return shiftService.updateShift(shift, Long.parseLong(id));
    }

}