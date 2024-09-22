package com.jgharris314.tgems.services.TableGame;

import com.jgharris314.tgems.models.TableGame.TableGameLog;
import com.jgharris314.tgems.repositories.TableGame.TableGameLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableGameLogService {
    @Autowired
    TableGameLogRepository tableGameLogRepository;

    public List<TableGameLog> getAllTableGameLogs() {
        return tableGameLogRepository.findAll();
    }

    public TableGameLog getTableGameLogById(Integer tableGameLogId) {
        return tableGameLogRepository.findById(tableGameLogId).orElse(null);
    }

    public TableGameLog createTableGameLog(TableGameLog tableGameLog) {
        return tableGameLogRepository.save(tableGameLog);
    }

    public List<TableGameLog> getAllTableGameLogsByTableId(Integer tableGameId) {
        return tableGameLogRepository.findAllByTableGameId(tableGameId);
    }
}
