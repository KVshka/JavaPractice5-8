package com.example.restaurantsproject.services;

import com.example.restaurantsproject.entities.Review;
import com.example.restaurantsproject.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantService restaurantService;

    public ReviewService(ReviewRepository reviewRepository, RestaurantService restaurantService) {
        this.reviewRepository = reviewRepository;
        this.restaurantService = restaurantService;
    }

    public void save(Review review) {
        reviewRepository.save(review);
        recalculateRestaurantRating(review.getRestaurantId());
    }

    public void remove(Review review) {
        reviewRepository.remove(review.getGuestId(), review.getRestaurantId());
        recalculateRestaurantRating(review.getRestaurantId());
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review findById(Long guestId, Long restaurantId) {
        return reviewRepository.findById(guestId, restaurantId);
    }

    //Пересчёт средней оценки
    private void recalculateRestaurantRating(Long restaurantId) {
        List<Review> ratings = reviewRepository.findByRestaurantId(restaurantId);
        if (!ratings.isEmpty()) {
            double avg = ratings.stream().mapToDouble(Review::getScore).average().orElse(0.0);
            restaurantService.updateRating(restaurantId, avg);
        }
    }
}
