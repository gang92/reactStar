package com.woorifis.reactstar.dto;

import java.sql.Date;

import com.woorifis.reactstar.domain.User;

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
    private int auth;
    private Date cr_dt;
    private Date lgn_dt;

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

    public User toEntity(String encryptPw, Date newCrDt) {
        return User.builder()
                .uid(uid)
                .name(name)
                .pw(encryptPw)
                .auth(0)
                .cr_dt(newCrDt)
                .lgn_dt(null)
                .build();
    }
}