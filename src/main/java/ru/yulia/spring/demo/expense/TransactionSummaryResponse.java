package ru.yulia.spring.demo.expense;

import java.math.BigDecimal;

public record TransactionSummaryResponse(
		BigDecimal balance,
		BigDecimal totalExpenses,
		BigDecimal monthlyIncome,
		BigDecimal monthlyExpenses
) {
}
