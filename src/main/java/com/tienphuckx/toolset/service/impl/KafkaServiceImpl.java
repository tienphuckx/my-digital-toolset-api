//package com.tienphuckx.toolset.service.impl;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tienphuckx.toolset.entity.email.Email;
//import com.tienphuckx.toolset.enums.EmailType;
//import com.tienphuckx.toolset.service.EmailService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@EnableKafka
//@Service
//@Slf4j
//public class KafkaServiceImpl {
//    @Autowired
//    private EmailService emailService;
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @KafkaListener(topics = "otp-auth-group", groupId = "otp-group-temp")
//    public void listenForOTP(String message) {
//        System.out.println("Received message: " + message);
//        try {
//            // topic upcoming is JSON
//            // topics = "otp-auth-group" is setting on Go project as a provider
//            // this java springboot api is a consumer
//            JsonNode jsonNode = objectMapper.readTree(message); //read upcoming json data
//            String email = jsonNode.get("email").asText();
//            String otp = jsonNode.get("otp").asText();
//
//            log.info("OTP received: {}, Email received is {}", otp, email);
//
//            Email emailObj = new Email();
//            emailObj.setTo(email);
//            emailObj.setSubject("OTP received from Kafka Go Server");
//            emailObj.setBody("OTP is " + otp);
//            emailObj.setEmailType(EmailType.TEXT);
//
//            String rs = emailService.sendEmailText(emailObj);
//            log.info("OTP sent: {}", rs);
//
//        }catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
