package com.tienphuckx.toolset.controller.email;

import com.tienphuckx.toolset.entity.email.Email;
import com.tienphuckx.toolset.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("send-text")
    public String sendEmailText(@RequestBody Email email) {
        return emailService.sendEmailText(email);
    }

    @PostMapping("send-html")
    public String sendEmailHtml(@RequestBody Email email) {
        return emailService.sendEmailHtml(email);
    }

    @PostMapping("send-attachment")
    public String sendEmailAttachment(@RequestBody Email email) {
        return emailService.sendEmailAttachment(email);
    }
}
