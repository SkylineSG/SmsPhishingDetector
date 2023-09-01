package org.example.controller;

import org.example.service.SmsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
class SubscriptionController {

    private final SmsService smsService;

    public SubscriptionController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/subscribe")
    public void subscribe() {
        smsService.subscribe("dostarczanie nr telefonu");
    }

    @PostMapping("/unsubscribe")
    public void unsubscribe() {
        smsService.unsubscribe("dostarczanie nr telefonu");
    }
}
