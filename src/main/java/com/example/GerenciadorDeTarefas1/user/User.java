//User é responsavel por mapear os campos que serão armazenados no banco de dados.

package com.example.GerenciadorDeTarefas1.user;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Table(name = "users")
@Entity
@Data //Esta é uma função do lombok, ela faz aquela parte de set e get que eu fazia manualmente: ex (public Long getId() {
        //return id;  // cuidado com maiúscula: 'id' e não 'Id'
    //}

//public void setId(Long id) {
    //this.id = id;
//})

public class User {

    @Id //Esta parte do codigo diz que: O campo é a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esta linha fala para o banco de dados gerar o ID automaticamente
    private Long id;

    private String email;
    private String name;

}