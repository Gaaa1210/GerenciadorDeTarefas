package com.example.GerenciadorDeTarefas1.category.web;

import com.example.GerenciadorDeTarefas1.category.domain.Category;
import com.example.GerenciadorDeTarefas1.category.port.CategoryRepositoryPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepositoryPort repository;

    public CategoryController(CategoryRepositoryPort repository) {
        this.repository = repository;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return repository.save(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return repository.findAll();
    }
}