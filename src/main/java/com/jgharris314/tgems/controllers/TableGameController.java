package com.jgharris314.tgems.controllers;

import com.jgharris314.tgems.models.TableGame;
import com.jgharris314.tgems.services.TableGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tableGames")
public class TableGameController {
    @Autowired
    TableGameService tableGameService;

    @GetMapping("/")
    public ResponseEntity<List<TableGame>> getAllTableGames() {
        return new ResponseEntity<>(tableGameService.getAllTableGames(), HttpStatus.OK);
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<TableGame> createTableGame(@RequestBody TableGame tableGame) {
        try {
            TableGame createdTableGame = tableGameService.createTableGame(tableGame);
            return new ResponseEntity<>(createdTableGame, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}
