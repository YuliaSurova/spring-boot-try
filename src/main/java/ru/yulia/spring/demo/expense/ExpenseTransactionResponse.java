package ru.yulia.spring.demo.expense;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseTransactionResponse(
		Long id,
		LocalDateTime occurredAt,
		String category,
		BigDecimal amount,
		String place
) {

	public static ExpenseTransactionResponse fromEntity(ExpenseTransaction transaction) {
		return new ExpenseTransactionResponse(
				transaction.getId(),
				transaction.getOccurredAt(),
				transaction.getCategory(),
				transaction.getAmount(),
				transaction.getPlace()
		);
	}
}
