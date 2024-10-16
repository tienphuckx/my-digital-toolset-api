package com.tienphuckx.toolset.service.impl;

import com.tienphuckx.toolset.entity.email.Email;
import com.tienphuckx.toolset.service.EmailService;
import com.tienphuckx.toolset.util.EmailSenderUtil;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String EMAIL_HOST = "tienphuckx@gmail.com";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendEmailText(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EMAIL_HOST);
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        try {
            javaMailSender.send(message);
            System.out.println("Email sent to " + email.getTo() + "Successfully!");
            return "Email sent to " + email.getTo() + "Successfully!";
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendEmailHtml(Email email) {
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(EMAIL_HOST);
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getBody(), true);

            javaMailSender.send(message);
            System.out.println("Email sent to " + email.getTo() + "Successfully!");
            return "Email sent to" + email.getTo() + "Successfully!";
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendEmailAttachment(Email email) {
        return "";
    }
}
