package com.company.timetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.timetracker.domain.Shift;
import com.company.timetracker.domain.ShiftRepository;
import com.company.timetracker.exceptions.PersonNotFoundException;

@Component
public class ShiftService{

    @Autowired
    private ShiftRepository shiftRepository;

    public List<Shift> getAllshifts(){
        return shiftRepository.findAll();
    }

    public Shift getShiftById(Long id)throws PersonNotFoundException{
        return shiftRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
    }

    public Shift addShift(Shift shift){
        return shiftRepository.save(shift);
    }

    public void deleteShift(Long id) throws PersonNotFoundException{
        Shift shift = shiftRepository.findById(id).orElseThrow(() -> new PersonNotFoundException()); 
        shiftRepository.delete(shift);
    }

    public Shift updateShift(Shift shift, Long id){
        shiftRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
        shiftRepository.deleteById(id);
        shift.setId(id);
        
        return shiftRepository.save(shift);
    }

}