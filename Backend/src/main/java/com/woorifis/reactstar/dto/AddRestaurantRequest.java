package com.woorifis.reactstar.dto;

import com.woorifis.reactstar.domain.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddRestaurantRequest {
    private Long id;
    private String name;
    private String addressSi;
    private String addressGu;
    private String addressDong;
    private String isConfirmed;
    public Restaurant toEntity() { // 생성자를 사용해 객체 생성
        return Restaurant.builder()
                .id(id)
                .name(name)
                .addressSi(addressSi)
                .addressGu(addressGu)
                .addressDong(addressDong)
                .isConfirmed(isConfirmed).build();
    }
}
