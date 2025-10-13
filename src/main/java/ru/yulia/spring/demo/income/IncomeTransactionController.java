package ru.yulia.spring.demo.income;

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
@RequestMapping("/api/transactions_income")
@Tag(name = "Income", description = "Учет доходов")
public class IncomeTransactionController {

	private final IncomeTransactionService service;

	public IncomeTransactionController(IncomeTransactionService service) {
		this.service = service;
	}

	@PostMapping("/create_income")
	@Operation(summary = "Создать транзакцию дохода")
	public ResponseEntity<IncomeTransactionResponse> create(@Valid @RequestBody CreateIncomeTransactionRequest request) {
		IncomeTransaction transaction = new IncomeTransaction(
				request.earnings_time(),
				//request.category(),
				request.salary(),
				request.job()
		);
		IncomeTransaction saved = service.save(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body(IncomeTransactionResponse.fromEntity(saved));
	}

	@GetMapping("/all_income")
	@Operation(summary = "Получить все транзакции доходов")
	public ResponseEntity<List<IncomeTransactionResponse>> findAll() {
		List<IncomeTransactionResponse> transactions = service.findAll()
				.stream()
				.map(IncomeTransactionResponse::fromEntity)
				.toList();
		return ResponseEntity.ok(transactions);
	}
}
