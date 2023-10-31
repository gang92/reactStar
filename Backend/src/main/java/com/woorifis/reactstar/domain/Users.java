package com.woorifis.reactstar.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.woorifis.reactstar.config.UserRole;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    @Column(name = "uid", updatable = false)
    private String uid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pw", nullable = false)
    private String pw;

    @Column(name = "auth", nullable = false)
    private UserRole auth;

    @Column(name = "cr_dt", nullable = false)
    @CreatedDate
    private LocalDateTime cr_dt;

    @Column(name = "lgn_dt", nullable = true)
    private LocalDateTime lgn_dt;

    @Builder
    public Users(String uid, String name, String pw, UserRole auth, LocalDateTime cr_dt, LocalDateTime lgn_dt) {
        this.uid = uid;
        this.name = name;
        this.pw = pw;
        this.auth = auth;
        this.cr_dt = cr_dt;
        this.lgn_dt = lgn_dt;
    }

}
