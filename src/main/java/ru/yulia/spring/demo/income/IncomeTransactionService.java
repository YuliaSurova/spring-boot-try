package ru.yulia.spring.demo.income;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IncomeTransactionService {

	private final IncomeTransactionRepository repository;

	public IncomeTransactionService(IncomeTransactionRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public IncomeTransaction save(IncomeTransaction transaction) {
		return repository.save(transaction);
	}

	@Transactional(readOnly = true)
	public List<IncomeTransaction> findAll() {
		return repository.findAll();
	}
}
