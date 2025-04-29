package com.example.GerenciadorDeTarefas1.category.adapter;

import com.example.GerenciadorDeTarefas1.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCategoryRepository extends JpaRepository<Category, Long> {
}