package com.woorifis.reactstar.repository;

import com.woorifis.reactstar.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

 /*   private static List<Restaurant> restaurantList = new ArrayList<>();

    *//* 맛집 테이블에 맛집을 등록한다. *//*
    public void register(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    *//* 전체 맛집 리스트 조회 *//*
    public List<Restaurant> findAll() {
        return restaurantList;
    }*/
}
