package ru.yulia.spring.demo.income;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record IncomeTransactionResponse(
		Long id,
		LocalDateTime earnings_time,
		//String category,
		BigDecimal salary,
		String job
) {

	public static IncomeTransactionResponse fromEntity(IncomeTransaction transaction) {
		return new IncomeTransactionResponse(
				transaction.getId(),
				transaction.getEarnings_time(),
				//transaction.getCategory(),
				transaction.getSalary(),
				transaction.getJob()
		);
	}
}