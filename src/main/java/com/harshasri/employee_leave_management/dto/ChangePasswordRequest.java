package com.harshasri.employee_leave_management.dto;
import lombok.Data;
@Data
public class ChangePasswordRequest {
     private String currentPassword;
    private String newPassword;
}
