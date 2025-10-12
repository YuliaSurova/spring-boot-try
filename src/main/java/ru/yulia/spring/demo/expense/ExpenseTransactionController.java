package ru.yulia.spring.demo.expense;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Expenses", description = "Учет расходов")
public class ExpenseTransactionController {

	private final ExpenseTransactionService service;

	public ExpenseTransactionController(ExpenseTransactionService service) {
		this.service = service;
	}

	@PostMapping("/create")
	@Operation(summary = "Создать транзакцию расхода")
	public ResponseEntity<ExpenseTransactionResponse> create(@Valid @RequestBody CreateExpenseTransactionRequest request) {
		ExpenseTransaction transaction = new ExpenseTransaction(
				request.occurredAt(),
				request.category(),
				request.amount(),
				request.place()
		);
		ExpenseTransaction saved = service.save(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body(ExpenseTransactionResponse.fromEntity(saved));
	}

	@GetMapping("/all")
	@Operation(summary = "Получить все транзакции расходов")
	public ResponseEntity<List<ExpenseTransactionResponse>> findAll() {
		List<ExpenseTransactionResponse> transactions = service.findAll()
				.stream()
				.map(ExpenseTransactionResponse::fromEntity)
				.toList();
		return ResponseEntity.ok(transactions);
	}
}
