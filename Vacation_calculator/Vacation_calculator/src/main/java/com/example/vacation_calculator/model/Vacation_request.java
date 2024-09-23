package com.example.vacation_calculator.model;

import java.time.LocalDate;

public class Vacation_request {
    private double average_salary;
    private int vacation_days;
    private LocalDate start_date;

    public double getAverage_salary() {

        return average_salary;
    }

    public void setAverage_salary(double average_salary) {

        this.average_salary = average_salary;
    }

    public int getVacation_days() {

        return vacation_days;
    }

    public void setVacation_days(int vacation_days) {

        this.vacation_days = vacation_days;
    }

    public LocalDate getStart_date() {

        return start_date;
    }

    public void setStart_date(LocalDate start_date) {

        this.start_date = start_date;
    }
}
