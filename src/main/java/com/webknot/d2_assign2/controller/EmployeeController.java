package com.webknot.d2_assign2.controller;

import com.webknot.d2_assign2.dto.EmployeeDto;
import com.webknot.d2_assign2.entity.Employee;
import com.webknot.d2_assign2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Manage Employees – Add, edit, and remove employee records.
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDto emp) {
        return ResponseEntity.ok(employeeService.addEmployee(emp));
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto emp) {
        Employee updatedEmployee = employeeService.updateEmployee(id, emp);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted");
    }

    //Edit Employee Information – Modify specific details like name, email, role, or department.
    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable Long id, @RequestBody EmployeeDto emp) {
        return ResponseEntity.ok(employeeService.updateEmployeeDetails(id, emp));
    }

    @PatchMapping("/{id}/add-skills")
    public ResponseEntity<Employee> addSkills(@PathVariable Long id, @RequestBody Set<Long> skillIds) {
        return ResponseEntity.ok(employeeService.addSkills(id, skillIds));
    }

    //Skill Set Management – Add or remove skills for employees.
    @PatchMapping("/{id}/remove-skills")
    public ResponseEntity<Employee> removeSkills(@PathVariable Long id, @RequestBody Set<Long> skillIds) {
        return ResponseEntity.ok(employeeService.removeSkills(id, skillIds));
    }
}
