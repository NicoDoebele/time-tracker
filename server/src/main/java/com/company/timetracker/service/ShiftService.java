package com.company.timetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.timetracker.domain.Shift;
import com.company.timetracker.domain.ShiftRepository;
import com.company.timetracker.exceptions.ShiftNotFoundException;

@Component
public class ShiftService{

    @Autowired
    private ShiftRepository shiftRepository;

    public List<Shift> getAllshifts(){
        return shiftRepository.findAll();
    }

    public Shift getShiftById(Long id)throws ShiftNotFoundException{
        return shiftRepository.findById(id).orElseThrow(() -> new ShiftNotFoundException());
    }

    public Shift addShift(Shift shift){
        return shiftRepository.save(shift);
    }

    public void deleteShift(Long id) throws ShiftNotFoundException{
        Shift shift = shiftRepository.findById(id).orElseThrow(() -> new ShiftNotFoundException()); 
        shiftRepository.delete(shift);
    }

    public Shift updateShift(Shift shift, Long id){
        shiftRepository.findById(id).orElseThrow(() -> new ShiftNotFoundException());
        shiftRepository.deleteById(id);
        shift.setId(id);
        
        return shiftRepository.save(shift);
    }

}