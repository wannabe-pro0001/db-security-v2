package com.db.security.repository;

import com.db.security.model.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<PassportEntity, Long> {
}
