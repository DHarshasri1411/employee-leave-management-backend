package com.harshasri.employee_leave_management.service;

import com.harshasri.employee_leave_management.exception.ResourceNotFoundException;
import com.harshasri.employee_leave_management.entity.Employee;
import com.harshasri.employee_leave_management.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import com.harshasri.employee_leave_management.dto.ChangePasswordRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
@RequiredArgsConstructor
@Service
public class EmployeeService {
     private final EmployeeRepository employeeRepository;

     public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
}
public Employee saveEmployee(Employee employee) {

    // First save to generate the database ID
    Employee savedEmployee = employeeRepository.save(employee);

    // Generate Employee ID (EMP001, EMP002, ...)
    String employeeId = String.format("EMP%03d", savedEmployee.getId());

    // Set the generated Employee ID
    savedEmployee.setEmployeeId(employeeId);

    // Save again with the generated Employee ID
    return employeeRepository.save(savedEmployee);
}

  public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Employee not found with id " + id));
}

   public Employee updateEmployee(Long id, Employee employee) {

    Employee existingEmployee = employeeRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Employee not found with id " + id));

    // Demo Employee
    if (existingEmployee.getEmployeeId().equals("EMP001")) {

        // Only these fields can be updated
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setLeaveBalance(employee.getLeaveBalance());

    } else {

        // Normal employees
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setLeaveBalance(employee.getLeaveBalance());

    }

    return employeeRepository.save(existingEmployee);
}

public void deleteEmployee(Long id) {

    Employee employee = employeeRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Employee not found"));

    if (employee.getEmployeeId().equals("EMP001")) {
        throw new RuntimeException("Demo employee cannot be deleted.");
    }

    employeeRepository.delete(employee);
}

public Employee login(String employeeId, String password) {

    Employee employee = employeeRepository.findByEmployeeId(employeeId)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Invalid Employee ID"));

    if (!employee.getPassword().equals(password)) {
        throw new RuntimeException("Invalid Password");
    }

    return employee;
}

public long getEmployeeCount() {
    return employeeRepository.count();
}

public Employee getEmployeeProfile(String employeeId) {

    return employeeRepository.findByEmployeeId(employeeId)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Employee Not Found"));

}

public Employee changePassword(String employeeId, ChangePasswordRequest request) {

    System.out.println("Employee ID = " + employeeId);
    System.out.println("Current = " + request.getCurrentPassword());
    System.out.println("New = " + request.getNewPassword());

    Employee employee = employeeRepository.findByEmployeeId(employeeId)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Employee Not Found"));
                    if (employee.getEmployeeId().equals("EMP001")) {
    throw new RuntimeException(
             "The demo account password cannot be changed. To test the Change Password feature, please log in using an employee account created by HR."
    );
}

    System.out.println("Old Password in DB = " + employee.getPassword());

    if (!employee.getPassword().equals(request.getCurrentPassword())) {
        throw new RuntimeException("Current password is incorrect");
    }

    employee.setPassword(request.getNewPassword());

    Employee saved = employeeRepository.save(employee);

   

    return saved;
}
public long getDepartmentCount() {
    return employeeRepository.countDepartments();
}
}




