package ru.yulia.spring.demo.income;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "income_transactions")
public class IncomeTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime earnings_time;

	//@Column(nullable = false, length = 100)
	//private String category;

	@Column(nullable = false, precision = 19, scale = 2)
	private BigDecimal salary;

	@Column(nullable = false, length = 255)
	private String job;

	protected IncomeTransaction() {
		// for JPA
	}

	public IncomeTransaction(LocalDateTime earnings_time, BigDecimal salary, String job) {
		this.earnings_time = earnings_time;
		//this.category = category;
		this.salary = salary;
		this.job = job;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getEarnings_time() {
		return earnings_time;
	}

	//public String getCategory() {
	//	return category;
	//}

	public BigDecimal getSalary() {
		return salary;
	}

	public String getJob() {
		return job;
	}
    
}
