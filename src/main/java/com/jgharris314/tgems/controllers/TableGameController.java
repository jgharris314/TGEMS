package com.jgharris314.tgems.controllers;

import com.jgharris314.tgems.models.TableGame.TableGame;
import com.jgharris314.tgems.services.TableGameService;
import com.jgharris314.tgems.requestBodies.UpdateTableGameStatus;
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

    @PostMapping("/open")
    @ResponseBody
    public ResponseEntity<TableGame> openTableGame(@RequestBody UpdateTableGameStatus updateTableGameStatus) {
        try {
            TableGame tableGameToOpen = tableGameService.updateTableGameStatus(updateTableGameStatus, true);
            if (tableGameToOpen == null) {
                throw new Exception("Table is already open");
            }
            return new ResponseEntity<TableGame>(tableGameToOpen, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/close")
    @ResponseBody
    public ResponseEntity<TableGame> closeTableGame(@RequestBody UpdateTableGameStatus updateTableGameStatus) {
        try {
            TableGame tableGameToClose = tableGameService.updateTableGameStatus(updateTableGameStatus, false);
            if (tableGameToClose == null) {
                throw new Exception("Table is already closed");
            }
            return new ResponseEntity<TableGame>(tableGameToClose, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
