package com.webknot.d2_assign2.repository;

import com.webknot.d2_assign2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
