package com.example.GerenciadorDeTarefas1.notification;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private final List<String> notifications = new ArrayList<>();

    public void addNotification(String jsonNotification) {
        notifications.add(jsonNotification);
    }

    public List<String> getAllNotifications() {
        return notifications;
    }
}
