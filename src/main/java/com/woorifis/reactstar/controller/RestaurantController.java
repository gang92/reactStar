package com.woorifis.reactstar.controller;

import com.woorifis.reactstar.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.woorifis.reactstar.service.RestaurantService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurantList")
    public String restaurantList(Model model) {
        model.addAttribute("restaurantList", restaurantService.findAll());
        return "restaurant/restaurantList";
    }

    @GetMapping("/registerRestaurant")
    public String showRegisterRestaurantForm() {
        return "restaurant/registerRestaurant";
    }

    @PostMapping("/registerRestaurant")
    public String registerRestaurant(Restaurant restaurant) {
        restaurantService.register(restaurant);
        return "redirect:/";
    }
}
