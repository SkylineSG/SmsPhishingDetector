package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String message) {
        System.out.println("Powiadomienie: " + message);
    }

    public void notifyAdministrator(String message, String sender) {
        System.out.println("Administrator: " + message + " (Nadawca: " + sender + ")");
    }
}
