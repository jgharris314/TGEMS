package com.jgharris314.tgems.services;

import com.jgharris314.tgems.models.Employee;
import com.jgharris314.tgems.models.Pit;
import com.jgharris314.tgems.pit.requestBodies.ClosePit;
import com.jgharris314.tgems.pit.requestBodies.OpenPit;
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

    public Pit openPit(OpenPit openPit) {
        Pit pitToOpen = this.getPit(openPit.getPitId());
        Employee employeeThatOpened = employeeService.getEmployeeById(openPit.getEmployeeId());
        pitToOpen.setIsOpen(true);
        pitToOpen.setEmployee(employeeThatOpened);
        pitRepository.save(pitToOpen);
        return pitToOpen;
    }

    public Pit closePit(ClosePit closePit) {
        Pit pitToClose = this.getPit(closePit.getPitId());
        Employee employeeThatClosed = employeeService.getEmployeeById(closePit.getEmployeeId());
        pitToClose.setIsOpen(false);
        pitToClose.setEmployee(employeeThatClosed);
        pitRepository.save(pitToClose);
        return pitToClose;
    }
}
