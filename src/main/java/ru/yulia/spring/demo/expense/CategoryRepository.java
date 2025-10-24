package ru.yulia.spring.demo.expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	boolean existsByNameIgnoreCase(String name);
}
