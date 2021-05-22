package com.example.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Map;


@Service
@AllArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setText(email,true);
            helper.setTo(to);
            helper.setSubject("Testing Mail from Here");
            helper.setFrom("hello@ushan.com");
            javaMailSender.send(mimeMessage);
        }catch (MessagingException e){
            log.error("Failed to send email",e);
            throw new IllegalStateException("Failed to send Email");
        }
    }

    @Override
    public void send(InternetAddress[] to, InternetAddress[] cc, String subject, String mailTemplate, Map<String, Object> templateModel) {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);
        String htmlBody = springTemplateEngine.process(mailTemplate,thymeleafContext);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setFrom("noreply@email.com");
            helper.setTo(to);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(htmlBody,true);
            helper.setSentDate(new Date());
            javaMailSender.send(mimeMessage);
        }catch (MessagingException e){
            log.error("Failed to send email",e);
            throw new IllegalStateException("Failed to send Email");
        }
    }


}
