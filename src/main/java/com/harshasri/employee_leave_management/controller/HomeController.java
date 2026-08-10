package com.harshasri.employee_leave_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HomeController {

   @GetMapping("/")
  
    public String home() {
        return "Employee Leave Management Backend is running successfully!";
    }
}