package com.example.maildemo.service;

import com.example.maildemo.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
public class MailService {
    @Autowired
    private JavaMailSenderImpl sender;

    public void sendEmail(MailDto mailDto) {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper=setMessageHelper(mailDto,helper);
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public MimeMessageHelper  setMessageHelper(MailDto mailDto,MimeMessageHelper helper) throws MessagingException {
        if(null!=mailDto.getFrom()) helper.setFrom(mailDto.getFrom());
        if(null!=mailDto.getReplyTo())helper.setReplyTo(mailDto.getReplyTo());
        if (null!=mailDto.getText())helper.setText(mailDto.getText());
        if(null!=mailDto.getSubject())helper.setSubject(mailDto.getSubject());
        if(null!=mailDto.getFile())helper.addAttachment(mailDto.getFile().getOriginalFilename(),mailDto.getFile());
        if (null!=mailDto.getCc()||null!=mailDto.getCcList()){
            if(null!=mailDto.getCc()) helper.setBcc(mailDto.getCc());
            else helper.setBcc(mailDto.getCcList());
        }
        if (null!=mailDto.getReceiver()||null!=mailDto.getReceivers()){
            if(null!=mailDto.getReceiver()) helper.setTo(mailDto.getReceiver());
            else helper.setTo(mailDto.getReceivers());
        }
        return helper;
    }

}


