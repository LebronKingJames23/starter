package com.example.maildemo.config;

import com.example.maildemo.service.MailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailAutoConfiguration {

    @Bean
    public MailService getMailService(){
        return new MailService();
    }


}
