package com.jgharris314.tgems.repositories.TableGame;

import com.jgharris314.tgems.models.TableGame.PreviousTableGameInventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreviousTableGameInventoryRecordRepository extends JpaRepository<PreviousTableGameInventoryRecord, Integer> {
}
