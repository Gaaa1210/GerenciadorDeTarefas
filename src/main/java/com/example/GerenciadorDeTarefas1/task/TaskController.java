package com.example.GerenciadorDeTarefas1.task;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/{userId}")
    public Task createTask (
            @PathVariable Long userId,
            @RequestBody Task task,
            @RequestParam Long categoryId
    ) {
        return taskService.createTask(task, userId, categoryId);
    }

    @GetMapping("/{userId}")
    public List<Task> getTasksByUser (@PathVariable Long userId) {
        return taskService.findTasksByUser(userId);
    }
}
