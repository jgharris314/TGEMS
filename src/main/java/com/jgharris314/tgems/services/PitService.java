package com.jgharris314.tgems.services;

import com.jgharris314.tgems.models.Employee;
import com.jgharris314.tgems.models.Pit;
import com.jgharris314.tgems.pit.requestBodies.UpdatePitStatus;
import com.jgharris314.tgems.repositories.PitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PitService {
    @Autowired
    PitRepository pitRepository;

    @Autowired
    EmployeeService employeeService;

    public List<Pit> getAllPits() {
        return pitRepository.findAll();
    }

    public Pit createPit(Pit pit) {
        return pitRepository.save(pit);
    }

    public Pit getPit(Integer pit_id) {
        Optional<Pit> optionalPit = pitRepository.findById(pit_id);
        return optionalPit.orElse(null);
    }

    public Pit updatePitStatus(UpdatePitStatus updatePitStatus, Boolean isOpen) {
        Pit pitToUpdate = this.getPit(updatePitStatus.getPitId());
        Employee employee = employeeService.getEmployeeById(updatePitStatus.getEmployeeId());
        pitToUpdate.setIsOpen(isOpen);
        pitToUpdate.setEmployee(employee);
        pitRepository.save(pitToUpdate);
        return pitToUpdate;
    }

}
