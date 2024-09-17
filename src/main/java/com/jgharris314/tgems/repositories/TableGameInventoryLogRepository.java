package com.jgharris314.tgems.repositories;

import com.jgharris314.tgems.models.TableGameInventoryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableGameInventoryLogRepository extends JpaRepository<TableGameInventoryLog, Integer> {
    List<TableGameInventoryLog> findAllByTableGameInventoryId(Integer tableGameInventoryId);
}

