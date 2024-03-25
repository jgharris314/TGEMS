package com.jgharris314.tgems.services;

import com.jgharris314.tgems.models.Employee;
import com.jgharris314.tgems.models.Pit;
import com.jgharris314.tgems.models.PitLog;
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

    @Autowired
    PitLogService pitLogService;

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
        Integer employeeId = updatePitStatus.getEmployeeId();
        Integer pitId = updatePitStatus.getPitId();
        Pit pitToUpdate = this.getPit(pitId);

        if (pitToUpdate.getIsOpen() == isOpen) {
            return null;
        }
        Employee employee = employeeService.getEmployeeById(employeeId);
        pitToUpdate.setIsOpen(isOpen);
        pitToUpdate.setEmployee(employee);
        Pit updatedPit = pitRepository.save(pitToUpdate);

        PitLog pitLog = new PitLog(employeeId, pitId, isOpen);

        pitLogService.createPitLog(pitLog);
        return updatedPit;
    }

}
