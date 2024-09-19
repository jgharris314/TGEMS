package com.jgharris314.tgems.services;

import com.jgharris314.tgems.enums.TableGameInventoryLogType;
import com.jgharris314.tgems.models.Employee;
import com.jgharris314.tgems.models.TableGame.TableGame;
import com.jgharris314.tgems.models.TableGame.TableGameInventoryLog;
import com.jgharris314.tgems.repositories.TableGameRepository;
import com.jgharris314.tgems.requestBodies.UpdateTableGameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableGameService {
    @Autowired
    TableGameRepository tableGameRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    TableGameInventoryLogService tableGameInventoryLogService;

    public List<TableGame> getAllTableGames() {
        return tableGameRepository.findAll();
    }

    public TableGame getTableGameById(Integer tableGameId) {
        return tableGameRepository.findById(tableGameId).orElse(null);
    }

    public TableGame createTableGame(TableGame tableGame) {
        return tableGameRepository.save(tableGame);
    }

    public TableGame updateTableGameStatus(UpdateTableGameStatus updateTableGameStatus, Boolean isOpen) {
        Integer employeeId = updateTableGameStatus.getEmployeeId();
        Integer tableGameId = updateTableGameStatus.getTableGameId();
        TableGame tableGameToUpdate = this.getTableGameById(tableGameId);

        if (tableGameToUpdate.getIsOpen() == isOpen) {
            return null;
        }
        Employee employee = employeeService.getEmployeeById(employeeId);
        tableGameToUpdate.setIsOpen(isOpen);
        tableGameToUpdate.setEmployee(employee);
        TableGame updatedTableGame = tableGameRepository.save(tableGameToUpdate);

        TableGameInventoryLog tableGameInventoryLog = new TableGameInventoryLog(
                employee,
                updatedTableGame.getTableGameInventory().getTableGameInventoryId(),
                0,
                isOpen ? TableGameInventoryLogType.opener : TableGameInventoryLogType.closer);

        tableGameInventoryLogService.createTableGameInventoryLog(tableGameInventoryLog);
        return updatedTableGame;
    }
}
