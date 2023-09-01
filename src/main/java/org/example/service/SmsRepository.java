package org.example.service;

import org.example.model.SmsMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SmsRepository extends JpaRepository<SmsMessage, Long> {
    //zapytania do bazy danych
}
