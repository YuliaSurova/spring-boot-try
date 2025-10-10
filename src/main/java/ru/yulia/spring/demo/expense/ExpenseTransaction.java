package ru.yulia.spring.demo.expense;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense_transactions")
public class ExpenseTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime occurredAt;

	@Column(nullable = false, length = 100)
	private String category;

	@Column(nullable = false, precision = 19, scale = 2)
	private BigDecimal amount;

	@Column(nullable = false, length = 255)
	private String place;

	protected ExpenseTransaction() {
		// for JPA
	}

	public ExpenseTransaction(LocalDateTime occurredAt, String category, BigDecimal amount, String place) {
		this.occurredAt = occurredAt;
		this.category = category;
		this.amount = amount;
		this.place = place;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getOccurredAt() {
		return occurredAt;
	}

	public String getCategory() {
		return category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getPlace() {
		return place;
	}
}
