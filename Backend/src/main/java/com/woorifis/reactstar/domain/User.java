package com.woorifis.reactstar.domain;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", updatable = false)
    private String uid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pw", nullable = false)
    private String pw;

    @Column(name = "auth", nullable = false)
    private int auth;

    @Column(name = "cr_dt", nullable = false)
    private Date cr_dt;

    @Column(name = "lgn_dt", nullable = true)
    private Date lgn_dt;

    @Builder
    public User(String uid, String name, String pw, int auth, Date cr_dt, Date lgn_dt) {
        this.uid = uid;
        this.name = name;
        this.pw = pw;
        this.auth = auth;
        this.cr_dt = cr_dt;
        this.lgn_dt = lgn_dt;
    }

}
