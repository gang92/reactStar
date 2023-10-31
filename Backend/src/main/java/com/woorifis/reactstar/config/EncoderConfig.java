package com.woorifis.reactstar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncoderConfig {
    //PW 암호화
    @Bean
    public BCryptPasswordEncoder pwEncoder() {
        return new BCryptPasswordEncoder();
    }
}
