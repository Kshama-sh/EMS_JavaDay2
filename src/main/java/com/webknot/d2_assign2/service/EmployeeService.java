package com.webknot.d2_assign2.service;
import com.webknot.d2_assign2.dto.EmployeeDto;
import com.webknot.d2_assign2.entity.Employee;
import com.webknot.d2_assign2.repository.EmployeeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
//@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public Employee addEmployee(EmployeeDto emp) {
        Employee employee = Employee.builder()
                .name(emp.getName())
                .email(emp.getEmail())
                .role(emp.getRole())
                .department(emp.getDepartment())
                .build();
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, EmployeeDto emp) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setName(emp.getName());
        existingEmployee.setEmail(emp.getEmail());
        existingEmployee.setRole(emp.getRole());
        existingEmployee.setDepartment(emp.getDepartment());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }

    public Employee updateEmployeeDetails(Long id, EmployeeDto emp) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee unavailable"));
        if (emp.getName() != null) existingEmployee.setName(emp.getName());
        if (emp.getEmail() != null) existingEmployee.setEmail(emp.getEmail());
        if (emp.getRole() != null) existingEmployee.setRole(emp.getRole());
        if (emp.getDepartment() != null) existingEmployee.setDepartment(emp.getDepartment());
        return employeeRepository.save(existingEmployee);
    }
}
