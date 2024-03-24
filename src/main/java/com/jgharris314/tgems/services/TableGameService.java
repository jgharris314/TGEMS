package com.jgharris314.tgems.services;

import com.jgharris314.tgems.models.TableGame;
import com.jgharris314.tgems.repositories.TableGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableGameService {
    @Autowired
    TableGameRepository tableGameRepository;

    public List<TableGame> getAllTableGames() {
        return tableGameRepository.findAll();
    }

    public TableGame getTableGameById(Integer tableGameId) {
        return tableGameRepository.findById(tableGameId).orElse(null);
    }

    public TableGame createTableGame(TableGame tableGame) {
        return tableGameRepository.save(tableGame);
    }
}
