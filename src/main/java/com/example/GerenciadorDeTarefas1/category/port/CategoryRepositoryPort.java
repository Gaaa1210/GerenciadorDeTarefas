package com.example.GerenciadorDeTarefas1.category.port;

import com.example.GerenciadorDeTarefas1.category.domain.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {
    Category save(Category category);
    Optional<Category> findById(Long id);
    List<Category> findAll();
    void deleteById(Long id);
}