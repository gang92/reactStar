package com.woorifis.reactstar.config;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.woorifis.reactstar.domain.Users;
import com.woorifis.reactstar.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenFilter extends OncePerRequestFilter{
    
    @Autowired
    private UserService userService;
    private final String secretKey = "secret-023151-key";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        // 값이 비어있으면 로그인 X
        if(authorizationHeader == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Bearer 로 시작하지 않으면 잘못된 토큰
        if(!authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Jwt Token 추출
        String token = authorizationHeader.split(" ")[1];

        // 만료 시 인증 X
        if(JwtTokenUtil.isExpired(token, secretKey)) {
            filterChain.doFilter(request, response);
            return;
        }

        String UId = JwtTokenUtil.getUId(token, secretKey);
        Users loginUser = userService.getUserInfo(UId);

        // loginUser 정보로 UsernamePasswordAuthenticationToken 발급
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginUser.getUid(), null, List.of(new SimpleGrantedAuthority(loginUser.getAuth().name())));
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        // 권한 부여
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
