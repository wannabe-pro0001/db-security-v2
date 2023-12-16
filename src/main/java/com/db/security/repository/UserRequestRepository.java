package com.db.security.repository;


import com.db.security.model.UserRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRequestRepository extends JpaRepository<UserRequestEntity, Long> {
}
