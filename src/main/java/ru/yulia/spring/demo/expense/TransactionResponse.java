package ru.yulia.spring.demo.expense;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
		Long id,
		LocalDateTime occurredAt,
		String category,
		BigDecimal amount,
		String place,
		TransactionType type
) {

	public static TransactionResponse fromEntity(Transaction transaction) {
		return new TransactionResponse(
				transaction.getId(),
				transaction.getOccurredAt(),
				transaction.getCategory(),
				transaction.getAmount(),
				transaction.getPlace(),
				transaction.getType()
		);
	}
}
