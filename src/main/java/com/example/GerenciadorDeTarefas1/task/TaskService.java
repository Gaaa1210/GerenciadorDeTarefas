package com.example.GerenciadorDeTarefas1.task;

import com.example.GerenciadorDeTarefas1.category.domain.Category;
import com.example.GerenciadorDeTarefas1.category.port.CategoryRepositoryPort;
import com.example.GerenciadorDeTarefas1.notification.TaskCompletedEvent;
import com.example.GerenciadorDeTarefas1.user.User;
import com.example.GerenciadorDeTarefas1.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;


import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final CategoryRepositoryPort categoryRepository;
    private final ApplicationEventPublisher eventPublisher;


    public TaskService(TaskRepository taskRepository,
                       UserRepository userRepository,
                       CategoryRepositoryPort categoryRepository, ApplicationEventPublisher eventPublisher) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.eventPublisher = eventPublisher;
    }

    public Task createTask(Task task, Long userId, Long categoryId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        task.setUser(user);
        task.setCategory(category);

        return taskRepository.save(task);
    }


    public List<Task> findTasksByUser (Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public void completeTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setCompleted(true);
        taskRepository.save(task);

        // Disparar evento
        eventPublisher.publishEvent(new TaskCompletedEvent(this, task.getTitle()));
    }
}
