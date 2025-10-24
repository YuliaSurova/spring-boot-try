package ru.yulia.spring.demo.expense;

public record CategoryResponse(
		Long id,
		String name,
		String color
) {
	public static CategoryResponse fromEntity(Category category) {
		return new CategoryResponse(
				category.getId(),
				category.getName(),
				category.getColor()
		);
	}
}
