package com.example.vacation_calculator.controller;

import com.example.vacation_calculator.service.Vacation_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
public class Vacation_controller {

    private final Vacation_service vacation_calculator_service;

    @Autowired
    public Vacation_controller(Vacation_service vacation_calculator_service) {
        this.vacation_calculator_service = vacation_calculator_service;
    }

    @GetMapping
    public double calculate_vacation_pay(@RequestParam double average_salary,
                                         @RequestParam int vacation_days,
                                         @RequestParam String start_date) {
        LocalDate startDate = LocalDate.parse(start_date);
        return vacation_calculator_service.calculation(average_salary, vacation_days, startDate);
    }
}