package org.example.controller;

import org.example.model.PhishingChecker;
import org.example.model.SmsMessage;
import org.example.service.NotificationService;
import org.example.service.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Component
public class SmsController {

    private final SmsRepository smsRepository;
    private final PhishingChecker phishingChecker;
    private final NotificationService notificationService;

    @Autowired
    public SmsController(
            SmsRepository smsRepository,
            PhishingChecker phishingChecker,
            NotificationService notificationService) {
        this.smsRepository = smsRepository;
        this.phishingChecker = phishingChecker;
        this.notificationService = notificationService;
    }

    @PostMapping("/receive")
    public void receiveSms(@RequestBody SmsMessage smsMessage) {
        smsRepository.save(smsMessage);

        if (phishingChecker.isPhishingURL(smsMessage.getMessage())) {

           // Kod do zablokowania URL w systemie lub w bazie danych

            notificationService.sendNotification("Znaleziono podejrzany URL w SMS-ie");

            notificationService.notifyAdministrator("Administrator, znaleziono podejrzany URL w SMS-ie", smsMessage.getSender());
        }
    }
}
