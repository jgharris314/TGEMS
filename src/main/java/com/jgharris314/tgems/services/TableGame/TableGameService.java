package com.jgharris314.tgems.services.TableGame;

import com.jgharris314.tgems.enums.TableGameInventoryLogType;
import com.jgharris314.tgems.models.Employee;
import com.jgharris314.tgems.models.TableGame.PreviousTableGameInventoryRecord;
import com.jgharris314.tgems.models.TableGame.TableGame;
import com.jgharris314.tgems.models.TableGame.TableGameInventoryLog;
import com.jgharris314.tgems.models.TableGame.UpdatedTableGameInventoryRecord;
import com.jgharris314.tgems.repositories.TableGame.TableGameRepository;
import com.jgharris314.tgems.requestBodies.UpdateTableGameStatus;
import com.jgharris314.tgems.services.EmployeeService;
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

    @Autowired
    PreviousTableGameInventoryRecordService previousTableGameInventoryRecordService;

    @Autowired
    UpdatedTableGameInventoryRecordService updatedTableGameInventoryRecordService;

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

        generateTableGameInventoryLog(tableGameToUpdate, employee);

        return tableGameRepository.save(tableGameToUpdate);

    }

    private void generateTableGameInventoryLog(TableGame tableGame, Employee employee) {
        PreviousTableGameInventoryRecord previousTableGameInventoryRecord =
                previousTableGameInventoryRecordService.
                        createPreviousTableGameInventoryRecord(tableGame.getTableGameInventory());

        UpdatedTableGameInventoryRecord updatedTableGameInventoryRecord =
                updatedTableGameInventoryRecordService.
                        createUpdatedTableGameInventoryRecord(tableGame.getTableGameInventory());

        TableGameInventoryLog tableGameInventoryLog = new TableGameInventoryLog(
                employee,
                tableGame.getTableGameInventory().getTableGameInventoryId(),
                0,
                tableGame.getIsOpen() ? TableGameInventoryLogType.opener : TableGameInventoryLogType.closer,
                previousTableGameInventoryRecord,
                updatedTableGameInventoryRecord
        );

        tableGameInventoryLogService.createTableGameInventoryLog(tableGameInventoryLog);
    }
}
