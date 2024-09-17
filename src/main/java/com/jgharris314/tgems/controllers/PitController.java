package com.jgharris314.tgems.controllers;

import com.jgharris314.tgems.models.Pit;
import com.jgharris314.tgems.requestBodies.UpdatePitStatus;
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
    public ResponseEntity<Pit> createPit(@RequestBody Pit pit) {
        try {
            Pit createdPit = pitService.createPit(pit);
            return new ResponseEntity<>(createdPit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/open")
    @ResponseBody
    public ResponseEntity<Pit> openPit(@RequestBody UpdatePitStatus updatePitStatus) {
        try {
            Pit pitToOpen = pitService.updatePitStatus(updatePitStatus, true);
            if (pitToOpen == null) {
                throw new Exception("Pit is already opened");
            }
            return new ResponseEntity<>(pitToOpen, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/close")
    @ResponseBody
    public ResponseEntity<Pit> closePit(@RequestBody UpdatePitStatus updatePitStatus) {
        try {
            Pit pitToClose = pitService.updatePitStatus(updatePitStatus, false);
            if (pitToClose == null) {
                throw new Exception("Pit is already closed");
            }
            return new ResponseEntity<>(pitToClose, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
