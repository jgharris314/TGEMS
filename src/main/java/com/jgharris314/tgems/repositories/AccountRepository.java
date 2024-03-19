package com.jgharris314.tgems.repositories;

import com.jgharris314.tgems.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
