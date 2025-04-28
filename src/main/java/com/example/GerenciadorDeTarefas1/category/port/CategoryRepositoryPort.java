package com.example.GerenciadorDeTarefas1.category.port;

import com.example.GerenciadorDeTarefas1.category.domain.Category;
import java.util.List;

public interface CategoryRepositoryPort {
    Category save(Category category);
    List<Category> findAll();
}