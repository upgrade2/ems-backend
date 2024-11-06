package com.example.emsbackend.controller;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto response = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return  new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<EmployeeDto>> getAllEmp(){
        List<EmployeeDto> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }
}