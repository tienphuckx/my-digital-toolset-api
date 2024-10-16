package com.tienphuckx.toolset.service;

import com.tienphuckx.toolset.entity.email.Email;

public interface EmailService {
    String sendEmailText(Email email);
    String sendEmailHtml(Email email);
    String sendEmailAttachment(Email email);
}
