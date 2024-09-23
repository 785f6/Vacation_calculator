package com.example.vacation_calculator.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class Vacation_service {

    private final Set<LocalDate> holidays = Set.of(
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 2),
            LocalDate.of(2024, 1, 3),
            LocalDate.of(2024, 1, 4),
            LocalDate.of(2024, 1, 5),
            LocalDate.of(2024, 1, 6),
            LocalDate.of(2024, 1, 7),
            LocalDate.of(2024, 1, 8),
            LocalDate.of(2024, 3, 8),
            LocalDate.of(2024, 5, 1),
            LocalDate.of(2024, 5, 9),
            LocalDate.of(2024, 2, 23),
            LocalDate.of(2024, 6, 12),
            LocalDate.of(2024, 11, 4)
    );

    public double calculation(double average_salary, int vacation_days, LocalDate start_date) {
        int actual_days = vacation_days;

        if (average_salary <= 0 || vacation_days <= 0)
            return 0.0;
        else {
            for (int i = 0; i < vacation_days; ++i) {
                LocalDate vacation_day = start_date.plusDays(i);
                if (vacation_day.getDayOfWeek().getValue() > 5 || holidays.contains(vacation_day)) {
                    actual_days--;
                }
            }
            return average_salary  / 29.3 * actual_days;
        }
    }
}
