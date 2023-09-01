package org.example.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SmsService {

    private Set<String> subscribedUsers = new HashSet<>();

    public void subscribe(String phoneNumber) {
        subscribedUsers.add(phoneNumber);
    }

    public void unsubscribe(String phoneNumber) {
        subscribedUsers.remove(phoneNumber);
    }
}
