package com.jgharris314.tgems.controllers;

import com.jgharris314.tgems.models.Employee;
import com.jgharris314.tgems.models.Pit;
import com.jgharris314.tgems.pit.requestBodies.ClosePit;
import com.jgharris314.tgems.pit.requestBodies.OpenPit;
import com.jgharris314.tgems.services.EmployeeService;
import com.jgharris314.tgems.services.PitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pits")
public class PitController {
    @Autowired
    PitService pitService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Pit>> getAllEmployees() {
        return new ResponseEntity<>(pitService.getAllPits(), HttpStatus.OK);
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<Pit> createEmployee(@RequestBody Pit pit) {
        try {
            Pit createdPit = pitService.createPit(pit);
            return new ResponseEntity<>(createdPit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/open")
    @ResponseBody
    public ResponseEntity<Pit> openPit(@RequestBody OpenPit openPit) {
        try {
            Pit pitToOpen = pitService.openPit(openPit);
            return new ResponseEntity<>(pitToOpen, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/close")
    @ResponseBody
    public ResponseEntity<Pit> closePit(@RequestBody ClosePit closePit) {
        try {
            Pit pitToClose = pitService.closePit(closePit);
            return new ResponseEntity<>(pitToClose, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
