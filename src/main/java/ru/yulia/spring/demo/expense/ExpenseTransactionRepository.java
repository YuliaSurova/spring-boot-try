package ru.yulia.spring.demo.expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTransactionRepository extends JpaRepository<ExpenseTransaction, Long> {
}
