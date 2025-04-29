package com.example.GerenciadorDeTarefas1.category.adapter;

import com.example.GerenciadorDeTarefas1.category.domain.Category;
import com.example.GerenciadorDeTarefas1.category.port.CategoryRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryJpaAdapter implements CategoryRepositoryPort {

    private final JpaRepository<Category, Long> repository;

    public CategoryJpaAdapter(JpaRepository<Category, Long> repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}