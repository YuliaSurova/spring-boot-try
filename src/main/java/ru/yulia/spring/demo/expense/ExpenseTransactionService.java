package ru.yulia.spring.demo.expense;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExpenseTransactionService {

	private final ExpenseTransactionRepository repository;

	public ExpenseTransactionService(ExpenseTransactionRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public ExpenseTransaction save(ExpenseTransaction transaction) {
		return repository.save(transaction);
	}
}
