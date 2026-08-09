package com.harshasri.employee_leave_management.repository;

import com.harshasri.employee_leave_management.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long>  {
     List<Leave> findByEmployeeId(String employeeId);

    List<Leave> findByStatus(String status);
    long countByStatus(String status);
   long countByEmployeeIdAndStatus(String employeeId, String status);
}
