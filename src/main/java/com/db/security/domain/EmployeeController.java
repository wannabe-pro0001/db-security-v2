package com.db.security.domain;

import com.db.security.model.EmployeeEntity;
import com.db.security.repository.EmployeeRepository;
import com.db.security.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeEntity getEmployee() {
        return employeeService.getEmployee();
    }
}
