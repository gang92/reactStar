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
    private final String isConfirmed;

    public RestaurantResponse(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.addressSi = restaurant.getAddressSi();
        this.addressGu = restaurant.getAddressGu();
        this.addressDong = restaurant.getAddressDong();
        this.isConfirmed = restaurant.getIsConfirmed();
    }
}
