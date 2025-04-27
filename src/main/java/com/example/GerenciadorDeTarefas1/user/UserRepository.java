// UserRepository é responsável por conversar diretamente com o banco de dados.

package com.example.GerenciadorDeTarefas1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Aqui estamos conectando a entidade User ao banco de dados usando um repositório JPA
}
