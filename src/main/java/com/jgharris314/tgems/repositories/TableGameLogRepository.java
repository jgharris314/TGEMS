package com.jgharris314.tgems.repositories;

import com.jgharris314.tgems.models.TableGameLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableGameLogRepository extends JpaRepository<TableGameLog, Integer> {
}
