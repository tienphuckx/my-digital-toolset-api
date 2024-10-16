package com.tienphuckx.toolset.email;

import com.tienphuckx.toolset.util.EmailSenderUtil;
import jakarta.mail.Quota;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {

    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Test
    void sendEmail() {
        String to = "tienphuckx@gmail.com";
        String subject = "Subject: I'm testing email";
        String content = "This is a testing email";
        emailSenderUtil.sendEmail(to, subject, content);
    }

    @Test
    void sendEmailTemplate() throws IOException {
        String to = "tienphuckx@gmail.com";
        String subject = "Subject: I'm testing email";
        String content = "This is a testing email";

        Resource resource = new ClassPathResource("templates/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        emailSenderUtil.sendEmailTemplate(to, subject, htmlContent);


    }
}
