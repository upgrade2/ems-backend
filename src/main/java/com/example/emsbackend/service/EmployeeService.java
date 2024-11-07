package com.example.emsbackend.service;

import com.example.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long id , EmployeeDto employeeDto);
    void deleteEmployee(Long employeeId);
}
