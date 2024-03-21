package com.jgharris314.tgems.repositories;

import com.jgharris314.tgems.models.Pit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitRepository extends JpaRepository<Pit, Integer> {
}
