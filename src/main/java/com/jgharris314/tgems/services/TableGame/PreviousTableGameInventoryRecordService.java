package com.jgharris314.tgems.services.TableGame;

import com.jgharris314.tgems.models.TableGame.PreviousTableGameInventoryRecord;
import com.jgharris314.tgems.models.TableGame.TableGameInventory;
import com.jgharris314.tgems.repositories.TableGame.PreviousTableGameInventoryRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreviousTableGameInventoryRecordService {
    @Autowired
    PreviousTableGameInventoryRecordRepository previousTableGameInventoryRecordRepository;

    public PreviousTableGameInventoryRecord createPreviousTableGameInventoryRecord(
            TableGameInventory tableGameInventory) {
        PreviousTableGameInventoryRecord previousTableGameInventoryRecord =
                new PreviousTableGameInventoryRecord(tableGameInventory);
        return previousTableGameInventoryRecordRepository.save(previousTableGameInventoryRecord);
    }
}
