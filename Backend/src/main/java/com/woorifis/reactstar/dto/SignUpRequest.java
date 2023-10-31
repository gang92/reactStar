package com.woorifis.reactstar.dto;

import java.time.LocalDateTime;

import com.woorifis.reactstar.config.UserRole;
import com.woorifis.reactstar.domain.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignUpRequest {
    private String uid;
    private String name;
    private String pw;

    // public User toEntity() {
    //     return User.builder()
    //             .uid(uid)
    //             .name(name)
    //             .pw(pw)
    //             .auth(auth)
    //             .cr_dt(cr_dt)
    //             .lgn_dt(lgn_dt)
    //             .build();
    // }

    public Users toEntity(String encryptPw, LocalDateTime newCrDt) {
        return Users.builder()
                .uid(uid)
                .name(name)
                .pw(encryptPw)
                .auth(UserRole.USER)
                .cr_dt(newCrDt)
                .lgn_dt(null)
                .build();
    }
}