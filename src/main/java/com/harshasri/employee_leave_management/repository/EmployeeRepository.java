package com.harshasri.employee_leave_management.repository;

import com.harshasri.employee_leave_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeId(String employeeId);

    @Query("SELECT COUNT(DISTINCT e.department) FROM Employee e")
    long countDepartments();
}