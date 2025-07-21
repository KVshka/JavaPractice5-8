package com.example.restaurantsproject.services;

import com.example.restaurantsproject.entities.Restaurant;
import com.example.restaurantsproject.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void remove(Restaurant restaurant) {
        restaurantRepository.remove(restaurant.getId());
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public void updateRating(Long restaurantId, double averageScore) {
        restaurantRepository.findAll().stream()
                .filter(r -> r.getId().equals(restaurantId))
                .findFirst()
                .ifPresent(r -> r.setRate(BigDecimal.valueOf(averageScore)));
    }
}

