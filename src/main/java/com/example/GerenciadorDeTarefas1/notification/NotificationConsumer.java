package com.example.GerenciadorDeTarefas1.notification;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

@Component
public class NotificationConsumer {

    private final NotificationService notificationService;

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @EventListener
    public void handleTaskCompleted(TaskCompletedEvent event) {
        try {
            Map<String, Object> notification = new HashMap<>();
            notification.put("message", "Task completed!");
            notification.put("taskName", event.getTaskName());
            notification.put("timestamp", System.currentTimeMillis());

            ObjectMapper mapper = new ObjectMapper();
            String jsonNotification = mapper.writeValueAsString(notification);

            notificationService.addNotification(jsonNotification);
            System.out.println("Notification sent: " + jsonNotification);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
