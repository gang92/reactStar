package com.woorifis.reactstar.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "addressSi", nullable = false)
    private String addressSi;

    @Column(name = "addressGu", nullable = false)
    private String addressGu;

    @Column(name = "addressDong", nullable = false)
    private String addressDong;

    @Column(name = "isConfirmed", nullable = false)
    private String isConfirmed;

    @Builder
    public Comment(Long id, String name, String addressSi, String addressGu, String addressDong, String isConfirmed) {
        this.id = id;
        this.name = name;
        this.addressSi = addressSi;
        this.addressGu = addressGu;
        this.addressDong = addressDong;
        this.isConfirmed = isConfirmed;
    }
}
