package com.woorifis.reactstar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserConfig {

    //PW 암호화
    @Bean
    public BCryptPasswordEncoder pwEncoder() {
        return new BCryptPasswordEncoder();
    }

    //스프링 시큐리티 무시
    @Bean
    public WebSecurityCustomizer customize() {
        return (web) -> web.ignoring()
            .requestMatchers("/");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            //크로스 사이트
            .csrf((csrf) -> csrf
                .disable())
            //로그인 없이 접근 가능 페이지
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/user/login", "/user/signup").permitAll()
                .requestMatchers("/user/admin").hasAuthority("0")
                .anyRequest().authenticated())
            //로그인 체크 시 타는 URL
            .formLogin((form) -> form
                .loginPage("/user/login")
                .usernameParameter("uid")
                .passwordParameter("pw")
                .defaultSuccessUrl("/", true)
                .failureUrl("/user/login")
                .permitAll())
            //로그아웃 시
            .logout((logout) -> logout
                .logoutUrl("/")
                .permitAll());

        return http.build();
    }
}