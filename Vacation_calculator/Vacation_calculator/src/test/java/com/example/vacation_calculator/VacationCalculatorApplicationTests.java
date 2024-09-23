package com.example.vacation_calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.vacation_calculator.service.Vacation_service;

@SpringBootTest
class VacationCalculatorApplicationTests {
	// Тестирование расчета оплаты отпуска с корректными данными
	@Test
	void calculate_VacationPayWithValidData() {
		var service = new Vacation_service();
		LocalDate start_date = LocalDate.of(2024, 8, 1);

		double result = service.calculation(2930, 1, start_date);

		assertEquals(100.0, result, 0.01);
	}

	// Тестирование расчета с праздниками в отпуске
	@Test
	void calculate_VacationPayWithHolidays() {
		Vacation_service service = new Vacation_service();
		LocalDate start_date = LocalDate.of(2024, 1, 1);

		double result = service.calculation(2930, 10, start_date);

		assertEquals(200.0, result, 0.01);
	}


	// Тестирование расчета с отрицательным количеством
	@Test
	void calculate_VacationPayNegativeDays() {
		Vacation_service service = new Vacation_service();

		double result = service.calculation(1000, -5, LocalDate.now());

		assertEquals(0.0, result, 0.01);
	}

	// Тестирование расчета только с выходными/праздниками
	@Test
	void calculate_VacationPayAllHolidaysDays() {
		Vacation_service service = new Vacation_service();
		LocalDate start_date = LocalDate.of(2024, 1, 1);

		double result = service.calculation(1000, 3, start_date);

		assertEquals(0.0, result, 0.01);
	}

}
