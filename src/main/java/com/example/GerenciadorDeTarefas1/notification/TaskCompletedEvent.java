package com.example.GerenciadorDeTarefas1.notification;

import org.springframework.context.ApplicationEvent;

public class TaskCompletedEvent extends ApplicationEvent {
    private final String taskName;

    public TaskCompletedEvent(Object source, String taskName) {
        super(source);
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
}
