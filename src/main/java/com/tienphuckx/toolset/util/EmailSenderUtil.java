package com.tienphuckx.toolset.util;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component // set this a component then can be able to use  @Autowired
public class EmailSenderUtil {
    private static final String EMAIL_HOST = "tienphuckx.gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EMAIL_HOST);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            System.out.println("Email sent to " + to + "Successfully!");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendEmailTemplate(String to, String subject, String content) {
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(EMAIL_HOST);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
            System.out.println("Email sent to " + to + "Successfully!");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
