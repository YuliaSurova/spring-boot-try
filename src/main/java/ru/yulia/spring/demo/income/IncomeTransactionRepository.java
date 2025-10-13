package ru.yulia.spring.demo.income;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeTransactionRepository extends JpaRepository<IncomeTransaction, Long> {
}
