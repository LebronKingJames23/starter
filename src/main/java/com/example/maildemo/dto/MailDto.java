package com.example.maildemo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MailDto {

    private String receiver;

    private String[] receivers;

    private MultipartFile file;

    private String subject;

    private String[] ccList;

    private String cc;

    private String from;

    private String text;

    private String replyTo;



}
