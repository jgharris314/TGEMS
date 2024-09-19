package com.jgharris314.tgems.repositories;

import com.jgharris314.tgems.models.TableGame.TableGameLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableGameLogRepository extends JpaRepository<TableGameLog, Integer> {
    List<TableGameLog> findAllByTableGameId(Integer tableGameId);
}
