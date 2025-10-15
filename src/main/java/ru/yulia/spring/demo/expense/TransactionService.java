package ru.yulia.spring.demo.expense;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

@Service
public class TransactionService {

	private final TransactionRepository repository;

	public TransactionService(TransactionRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public Transaction save(Transaction transaction) {
		return repository.save(transaction);
	}

	@Transactional(readOnly = true)
	public List<Transaction> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public TransactionSummaryResponse getSummary() {
		List<Transaction> transactions = repository.findAll();
		BigDecimal totalIncome = BigDecimal.ZERO;
		BigDecimal totalExpenses = BigDecimal.ZERO;
		BigDecimal monthlyIncome = BigDecimal.ZERO;
		BigDecimal monthlyExpenses = BigDecimal.ZERO;
		YearMonth currentMonth = YearMonth.now();

		for (Transaction transaction : transactions) {
			boolean inCurrentMonth = YearMonth.from(transaction.getOccurredAt()).equals(currentMonth);
			if (transaction.getType() == TransactionType.INCOME) {
				totalIncome = totalIncome.add(transaction.getAmount());
				if (inCurrentMonth) {
					monthlyIncome = monthlyIncome.add(transaction.getAmount());
				}
			} else if (transaction.getType() == TransactionType.EXPENSE) {
				totalExpenses = totalExpenses.add(transaction.getAmount());
				if (inCurrentMonth) {
					monthlyExpenses = monthlyExpenses.add(transaction.getAmount());
				}
			}
		}

		BigDecimal balance = totalIncome.subtract(totalExpenses);
		return new TransactionSummaryResponse(balance, totalExpenses, monthlyIncome, monthlyExpenses);
	}
}
