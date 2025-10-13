package ru.yulia.spring.demo.income;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateIncomeTransactionRequest(
		@NotNull LocalDateTime earnings_time,//во сколько заработали
		//@NotBlank String category,//
		@NotNull @Positive BigDecimal salary,//сколько заработали
		@NotBlank String job//где заработали
) {
}