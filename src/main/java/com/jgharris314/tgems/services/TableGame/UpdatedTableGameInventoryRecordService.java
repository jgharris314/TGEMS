package com.jgharris314.tgems.services.TableGame;

import com.jgharris314.tgems.models.TableGame.TableGameInventory;
import com.jgharris314.tgems.models.TableGame.UpdatedTableGameInventoryRecord;
import com.jgharris314.tgems.repositories.TableGame.UpdatedTableGameInventoryRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatedTableGameInventoryRecordService {
    @Autowired
    UpdatedTableGameInventoryRecordRepository updatedTableGameInventoryRecordRepository;

    public UpdatedTableGameInventoryRecord createUpdatedTableGameInventoryRecord(
            TableGameInventory tableGameInventory) {
        UpdatedTableGameInventoryRecord updatedTableGameInventoryRecord =
                new UpdatedTableGameInventoryRecord(tableGameInventory);
        return updatedTableGameInventoryRecordRepository.save(updatedTableGameInventoryRecord);
    }
}
