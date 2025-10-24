package ru.yulia.spring.demo.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateTransactionRequest(
		@NotNull LocalDateTime occurredAt,
		@NotNull @Positive Long categoryId,
		@NotNull @Positive BigDecimal amount,
		@NotBlank String place,
		@NotNull TransactionType type
) {
}
