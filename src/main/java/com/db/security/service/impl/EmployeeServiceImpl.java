package com.db.security.service.impl;

import com.db.security.config.DataSourceContextHolder;
import com.db.security.config.DatasourceType;
import com.db.security.model.EmployeeEntity;
import com.db.security.repository.EmployeeRepository;
import com.db.security.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DataSourceContextHolder dataSourceContextHolder;
    @Override
    public EmployeeEntity getEmployee() {
        dataSourceContextHolder.setBranchContext(DatasourceType.XAC_THUC);
        return employeeRepository.findById(1L).orElse(null);
    }
}
