package ru.yulia.spring.demo.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateExpenseTransactionRequest(
		@NotNull LocalDateTime occurredAt,
		@NotBlank String category,
		@NotNull @Positive BigDecimal amount,
		@NotBlank String place
) {
}
