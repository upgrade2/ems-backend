package com.example.emsbackend.service.impl;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.exception.ResourceNotFoundException;
import com.example.emsbackend.mapper.EmployeeMapper;
import com.example.emsbackend.repository.EmployeeRepository;
import com.example.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with given id :"+id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployeeDto) {
       Employee employee= employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exists with given id :"+id));
       employee.setFirstName(updatedEmployeeDto.getFirstName());
       employee.setLastName(updatedEmployeeDto.getLastName());
       employee.setEmail(updatedEmployeeDto.getEmail());

      Employee updEmp= employeeRepository.save(employee);

       return EmployeeMapper.mapToEmployeeDto(updEmp);
    }
}
