package com.jgharris314.tgems.repositories;

import com.jgharris314.tgems.models.TableGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableGameRepository extends JpaRepository<TableGame, Integer> {
}
