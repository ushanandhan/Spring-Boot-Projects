package com.example.service;

import javax.mail.internet.InternetAddress;
import java.util.Map;

public interface EmailService {

    void send(String to,String mailTemplate, Map<String, Object> templateModel,String fileToAttach);
    void send(InternetAddress[] to, InternetAddress[] cc, String subject, String mailTemplate, Map<String, Object> templateModel);
}
