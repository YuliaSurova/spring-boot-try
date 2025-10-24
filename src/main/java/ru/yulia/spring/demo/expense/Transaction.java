package ru.yulia.spring.demo.expense;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime occurredAt;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@Column(nullable = false, precision = 19, scale = 2)
	private BigDecimal amount;

	@Column(nullable = false, length = 255)
	private String place;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private TransactionType type;

	protected Transaction() {
		// for JPA
	}

	public Transaction(LocalDateTime occurredAt, Category category, BigDecimal amount, String place, TransactionType type) {
		this.occurredAt = occurredAt;
		this.category = category;
		this.amount = amount;
		this.place = place;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getOccurredAt() {
		return occurredAt;
	}

	public Category getCategory() {
		return category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getPlace() {
		return place;
	}

	public TransactionType getType() {
		return type;
	}
}
