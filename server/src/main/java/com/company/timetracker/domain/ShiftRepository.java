package com.company.timetracker.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShiftRepository extends JpaRepository<Shift, Long>{

    @Query("SELECT s FROM Shift s WHERE person_id = ?1 AND id = (SELECT MAX(id) FROM Shift s WHERE person_id = ?1)")
    public Shift getLastShiftFromPerson(long personId);

    @Query("SELECT s FROM Shift s WHERE person_id = ?1")
    public List<Shift> getShiftsFromPerson(long personId);
}
