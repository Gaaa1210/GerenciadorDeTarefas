// User é responsável por mapear os campos que serão armazenados no banco de dados.

package com.example.GerenciadorDeTarefas1.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id // Define o campo 'id' como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz o banco gerar o ID automaticamente
    private Long id;

    private String email;
    private String name;

    // Construtor vazio (necessário para o JPA/Hibernate)
    public User() {}

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
