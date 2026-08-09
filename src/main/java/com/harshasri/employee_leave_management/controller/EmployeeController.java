package com.harshasri.employee_leave_management.controller;
import com.harshasri.employee_leave_management.dto.LoginRequest;
import com.harshasri.employee_leave_management.dto.ChangePasswordRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.harshasri.employee_leave_management.entity.Employee;
import com.harshasri.employee_leave_management.service.EmployeeService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.Optional;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RestController

public class EmployeeController {

private final EmployeeService employeeService;
@GetMapping("/employees")
public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
@PostMapping("/employees")
public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/employees/login")
public Employee login(@RequestBody LoginRequest request) {

    return employeeService.login(
            request.getEmployeeId(),
            request.getPassword()
    );

}

 @GetMapping("/employees/{id}")
  public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
   
   @PutMapping("/employees/{id}")
   public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
       //TODO: process PUT request
       
      return employeeService.updateEmployee(id, employee);
   }

   @DeleteMapping("/employees/{id}")
public String deleteEmployee(@PathVariable Long id){
     employeeService.deleteEmployee(id);
    return "Employee deleted successfully!";
}

@GetMapping("/employees/count")
public long getEmployeeCount() {
    return employeeService.getEmployeeCount();
}
@GetMapping("/employees/profile/{employeeId}")
public Employee getEmployeeProfile(@PathVariable String employeeId) {

    return employeeService.getEmployeeProfile(employeeId);

}

@PutMapping("/employees/change-password/{employeeId}")
public Employee changePassword(
    @PathVariable String employeeId,
    @RequestBody ChangePasswordRequest request) {
  System.out.println("Controller reached");
    return employeeService.changePassword(employeeId, request);
}

@GetMapping("/employees/departments/count")
public long getDepartmentCount() {
    return employeeService.getDepartmentCount();
}


 
}
