package com.example.GerenciadorDeTarefas1.category.adapter;

import com.example.GerenciadorDeTarefas1.category.domain.Category;
import com.example.GerenciadorDeTarefas1.category.port.CategoryRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryJpaAdapter implements CategoryRepositoryPort {

    private final SpringDataCategoryRepository repository;

    public CategoryJpaAdapter(SpringDataCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity entity = new CategoryEntity(category.getName());
        CategoryEntity savedEntity = repository.save(entity);
        category.setId(savedEntity.getId());
        return category;
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll().stream()
                .map(entity -> new Category(entity.getName()))
                .toList();
    }
}