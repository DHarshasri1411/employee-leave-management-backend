package com.harshasri.employee_leave_management.service;

import com.harshasri.employee_leave_management.entity.Leave;
import com.harshasri.employee_leave_management.repository.LeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.harshasri.employee_leave_management.entity.Employee;
import com.harshasri.employee_leave_management.repository.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LeaveService {
    private final LeaveRepository leaveRepository;

    public Leave applyLeave(Leave leave) {

        leave.setStatus("Pending");
        leave.setAppliedDate(LocalDate.now());

        return leaveRepository.save(leave);
    }

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public List<Leave> getEmployeeLeaves(String employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);
    }

  public Leave approveLeave(Long id) {

    Leave leave = leaveRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Leave Request Not Found"));

    leave.setStatus("Approved");

    Employee employee = employeeRepository
            .findByEmployeeId(leave.getEmployeeId())
            .orElseThrow(() -> new RuntimeException("Employee Not Found"));

    employee.setLeaveBalance(employee.getLeaveBalance() - 1);

    employeeRepository.save(employee);

    return leaveRepository.save(leave);
}
public Leave rejectLeave(Long id) {

    Leave leave = leaveRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Leave Request Not Found"));

    leave.setStatus("Rejected");

    return leaveRepository.save(leave);
}
public long getPendingLeaveCount() {
    return leaveRepository.countByStatus("Pending");
}

private final EmployeeRepository employeeRepository;

public long getEmployeePendingCount(String employeeId) {
    return leaveRepository.countByEmployeeIdAndStatus(employeeId, "Pending");
}

public long getEmployeeApprovedCount(String employeeId) {
    return leaveRepository.countByEmployeeIdAndStatus(employeeId, "Approved");
}



}
