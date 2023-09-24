package com.woorifis.reactstar.service;

import com.woorifis.reactstar.domain.Restaurant;
import com.woorifis.reactstar.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /* 맛집 등록 */
    public void register(Restaurant restaurant) {
        restaurantRepository.register(restaurant);
    }
    /* 전체 맛집 리스트 조회 */
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
}
