package com.example.GerenciadorDeTarefas1.user;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    // Injeção de dependência via construtor (igual ao seu UserService)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST /users - Cria um novo usuário
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser); // Retorna 200 OK com o usuário criado
    }

    // GET /users - Lista todos os usuários (nome do método bate com o UserService)
    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = userService.listUsers(); // Chama o método listUsers() do seu service
        return ResponseEntity.ok(users);
    }
}

