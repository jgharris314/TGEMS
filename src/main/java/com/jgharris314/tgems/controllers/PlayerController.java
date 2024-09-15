package com.jgharris314.tgems.controllers;

import com.jgharris314.tgems.models.Player;
import com.jgharris314.tgems.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "http://localhost:5173")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<List<Player>> getAllPlayer() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        try {
            Player createdPlayer = playerService.createPlayer(player);
            return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
