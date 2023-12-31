package com.woorifis.reactstar.controller;

import com.woorifis.reactstar.domain.Restaurant;
import com.woorifis.reactstar.dto.AddRestaurantRequest;
import com.woorifis.reactstar.dto.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.woorifis.reactstar.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/api/restaurants")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody AddRestaurantRequest request) {
        Restaurant savedRestaurant = restaurantService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedRestaurant);
    }
    @GetMapping("/api/restaurants")
    public ResponseEntity<List<RestaurantResponse>> findAllRestaurants() {
        List<RestaurantResponse> restaurants = restaurantService.findAll()
                .stream()
                .map(RestaurantResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(restaurants);
    }
    @GetMapping("/api/restaurants/{id}")
    public ResponseEntity<RestaurantResponse> findRestaurantById(@PathVariable long id) {
        Restaurant restaurant = restaurantService.findById(id);
        return ResponseEntity.ok()
                .body(new RestaurantResponse(restaurant));
    }
}
