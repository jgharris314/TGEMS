package com.jgharris314.tgems.repositories;

import com.jgharris314.tgems.models.PitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitLogRepository extends JpaRepository<PitLog, Integer> {
}
