package ru.yulia.spring.demo.expense;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Expenses", description = "Учет расходов и доходов")
public class TransactionController {

	private final TransactionService service;

	public TransactionController(TransactionService service) {
		this.service = service;
	}

	@PostMapping("/create")
	@Operation(summary = "Создать транзакцию")
	public ResponseEntity<TransactionResponse> create(@Valid @RequestBody CreateTransactionRequest request) {
		Transaction transaction = new Transaction(
				request.occurredAt(),
				request.category(),
				request.amount(),
				request.place(),
				request.type()
		);
		Transaction saved = service.save(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body(TransactionResponse.fromEntity(saved));
	}

	@GetMapping("/all")
	@Operation(summary = "Получить все транзакции расходов")
	public ResponseEntity<List<TransactionResponse>> findAll() {
		List<TransactionResponse> transactions = service.findAll()
				.stream()
				.map(TransactionResponse::fromEntity)
				.toList();
		return ResponseEntity.ok(transactions);
	}

	@GetMapping("/summary")
	@Operation(summary = "Получить сводные данные по операциям")
	public ResponseEntity<TransactionSummaryResponse> getSummary() {
		return ResponseEntity.ok(service.getSummary());
	}
	
	@Operation(summary = "Удалить транзакцию по ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
