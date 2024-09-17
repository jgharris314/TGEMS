package com.jgharris314.tgems.services;

import com.jgharris314.tgems.models.TableGameInventoryLog;
import com.jgharris314.tgems.repositories.TableGameInventoryLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableGameInventoryLogService {
    @Autowired
    TableGameInventoryLogRepository tableGameInventoryLogRepository;

    public List<TableGameInventoryLog> getAllTableGameInventoryLogs() {
        return tableGameInventoryLogRepository.findAll();
    }

    public TableGameInventoryLog getTableGameInventoryLogById(Integer tableGameInventoryLogId) {
        return tableGameInventoryLogRepository.findById(tableGameInventoryLogId).orElse(null);
    }

    public TableGameInventoryLog createTableGameInventoryLog(TableGameInventoryLog tableGameInventoryLog) {
        return tableGameInventoryLogRepository.save(tableGameInventoryLog);
    }

    public List<TableGameInventoryLog> getAllTableGameInventoryLogsByTableId(Integer tableGameInventoryLogId) {
        return tableGameInventoryLogRepository.findAllByTableGameInventoryId(tableGameInventoryLogId);
    }
}
