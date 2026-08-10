package com.harshasri.employee_leave_management.controller;

import com.harshasri.employee_leave_management.entity.Leave;
import com.harshasri.employee_leave_management.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class LeaveController {
    private final LeaveService leaveService;
    @PostMapping("/leave/apply")
    public Leave applyLeave(@RequestBody Leave leave) {
        return leaveService.applyLeave(leave);
    }

    @GetMapping("/leave")
    public List<Leave> getAllLeaves() {
        return leaveService.getAllLeaves();
    }
   
    @GetMapping("/leave/{employeeId}")
    public List<Leave> getEmployeeLeaves(@PathVariable String employeeId) {
        return leaveService.getEmployeeLeaves(employeeId);
    }
   @PutMapping("/leave/approve/{id}")
public Leave approveLeave(@PathVariable Long id) {
    return leaveService.approveLeave(id);
}

  @PutMapping("/leave/reject/{id}")
public Leave rejectLeave(@PathVariable Long id) {
    return leaveService.rejectLeave(id);
}
@GetMapping("/leave/pending-count")
public long getPendingLeaveCount() {
    return leaveService.getPendingLeaveCount();
}
@GetMapping("/leave/pending/{employeeId}")
public long getEmployeePendingCount(@PathVariable String employeeId) {
    return leaveService.getEmployeePendingCount(employeeId);
}

@GetMapping("/leave/approved/{employeeId}")
public long getEmployeeApprovedCount(@PathVariable String employeeId) {
    return leaveService.getEmployeeApprovedCount(employeeId);
}
}
