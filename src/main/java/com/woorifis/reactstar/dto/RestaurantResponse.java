package com.woorifis.reactstar.dto;

import com.woorifis.reactstar.domain.Restaurant;
import lombok.Getter;

@Getter
public class RestaurantResponse {
    private final Long id;
    private final String name;
    private final String addressSi;
    private final String addressGu;
    private final String addressDong;

    public RestaurantResponse(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.addressSi = restaurant.getAddressSi();
        this.addressGu = restaurant.getAddressGu();
        this.addressDong = restaurant.getAddressDong();
    }
}
