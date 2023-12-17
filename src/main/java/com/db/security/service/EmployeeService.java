package com.db.security.service;

import com.db.security.model.EmployeeEntity;
import com.db.security.request.EmployeeRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
public interface EmployeeService {
    String getEmployee(EmployeeRequest request);
}
