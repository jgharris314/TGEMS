package com.jgharris314.tgems.controllers;

import com.jgharris314.tgems.models.PitLog;
import com.jgharris314.tgems.services.PitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pitLogs")
public class PitLogController {
    @Autowired
    PitLogService pitLogService;

    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<List<PitLog>> getAllPitLogs() {
        return new ResponseEntity<>(pitLogService.getAllPitLogs(), HttpStatus.OK);
    }
}
