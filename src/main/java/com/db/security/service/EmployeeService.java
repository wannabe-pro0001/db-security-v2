package com.db.security.service;

import com.db.security.model.EmployeeEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface EmployeeService {
    public EmployeeEntity getEmployee();
}
