package com.example.GerenciadorDeTarefas1.task;

import com.example.GerenciadorDeTarefas1.category.domain.Category;
import com.example.GerenciadorDeTarefas1.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private boolean completed;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
