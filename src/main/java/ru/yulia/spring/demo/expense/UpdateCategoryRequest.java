package ru.yulia.spring.demo.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateCategoryRequest(
		@NotBlank @Size(max = 100) String name,
		@NotBlank @Size(max = 20) String color
) {
}
