package com.example.restaurantsproject.services;

import com.example.restaurantsproject.entities.Rate;
import com.example.restaurantsproject.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final RestaurantService restaurantService;

    public RatingService(RatingRepository ratingRepository, RestaurantService restaurantService) {
        this.ratingRepository = ratingRepository;
        this.restaurantService = restaurantService;
    }

    public void save(Rate rate) {
        ratingRepository.save(rate);
        recalculateRestaurantRating(rate.getRestaurantId());
    }

    public void remove(Rate rate) {
        ratingRepository.remove(rate);
        recalculateRestaurantRating(rate.getRestaurantId());
    }

    public List<Rate> findAll() {
        return ratingRepository.findAll();
    }

    public Rate findById(Long guestId, Long restaurantId) {
        return ratingRepository.findById(guestId, restaurantId).orElse(null);
    }

    //Пересчёт средней оценки
    private void recalculateRestaurantRating(Long restaurantId) {
        List<Rate> ratings = ratingRepository.findByRestaurantId(restaurantId);
        if (!ratings.isEmpty()) {
            double avg = ratings.stream().mapToInt(Rate::getScore).average().orElse(0);
            restaurantService.updateRating(restaurantId, avg);
        }
    }
}
