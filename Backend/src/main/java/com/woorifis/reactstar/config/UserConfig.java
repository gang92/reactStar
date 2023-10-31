package com.woorifis.reactstar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

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
            .requestMatchers(new AntPathRequestMatcher("/")
            );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            //크로스 사이트
            .csrf((csrf) -> csrf
                .disable())
            //로그인 없이 접근 가능 페이지 "/" "/user/login" "/user/signup"
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(new AntPathRequestMatcher("/"),
                new AntPathRequestMatcher("/user/login"),
                new AntPathRequestMatcher("/user/signup")
                ).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/user/admin"))
                .hasAuthority(UserRole.ADMIN.name())
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