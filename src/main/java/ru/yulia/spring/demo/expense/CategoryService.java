package ru.yulia.spring.demo.expense;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

	private final CategoryRepository repository;

	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public CategoryResponse create(CreateCategoryRequest request) {
		Category category = new Category(request.name(), request.color());
		return CategoryResponse.fromEntity(repository.save(category));
	}

	@Transactional(readOnly = true)
	public List<CategoryResponse> findAll() {
		return repository.findAll().stream()
				.map(CategoryResponse::fromEntity)
				.toList();
	}

	@Transactional(readOnly = true)
	public CategoryResponse findById(Long id) {
		return CategoryResponse.fromEntity(requireById(id));
	}

	@Transactional
	public CategoryResponse update(Long id, UpdateCategoryRequest request) {
		Category category = requireById(id);
		category.setName(request.name());
		category.setColor(request.color());
		return CategoryResponse.fromEntity(repository.save(category));
	}

	@Transactional
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new CategoryNotFoundException(id);
		}
		repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Category requireById(Long id) {
		return repository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
	}
}
