package com.woorifis.reactstar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class UserConfig {
    //PW 암호화
    @Bean
    public BCryptPasswordEncoder pwEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            //크로스 사이트
            .csrf((csrf) -> csrf
                .disable())
            //로그인 없이 접근 가능 페이지 "/" "/user/login" "/user/signup"
            .addFilterBefore(new JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(new AntPathRequestMatcher("/**")
                    // new AntPathRequestMatcher("/user/login"),
                    // new AntPathRequestMatcher("/user/signup"),
                    // new AntPathRequestMatcher("/api/**"),
                    // new AntPathRequestMatcher("/resources/**")
                ).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/restaurant/register"))
                .hasAnyRole(UserRole.USER.name(),UserRole.ADMIN.name())
                .requestMatchers(new AntPathRequestMatcher("/user/admin"))
                .hasRole(UserRole.ADMIN.name()))
            // //로그인 체크 시 타는 URL
            // .formLogin((form) -> form
            //     .loginPage("/user/login")
            //     .usernameParameter("uid")
            //     .passwordParameter("pw")
            //     .defaultSuccessUrl("/", true)
            //     .failureUrl("/user/login")
            //     .permitAll())
            //로그아웃 시
            .logout((logout) -> logout
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/")
                .permitAll());

        return http.build();
    }
}