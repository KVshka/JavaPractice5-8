package com.example.restaurantsproject.repositories;

import com.example.restaurantsproject.entities.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReviewRepository {
    private final List<Review> reviews = new ArrayList<>();

    public void save(Review review) {
        reviews.add(review);
    }

    public void remove(Long guestId, Long restaurantId) {
        reviews.removeIf(r -> r.getGuestId().equals(guestId) && r.getRestaurantId().equals(restaurantId));;
    }

    public void update(Long guestId, Long restaurantId, Review review){
        remove(guestId, restaurantId);
        save(review);
    }

    public List<Review> findAll() {
        return new ArrayList<>(reviews);
    }

    public Review findById(Long guestId, Long restaurantId) {
                return reviews.stream()
                        .filter(r -> r.getGuestId().equals(guestId) && r.getRestaurantId().equals(restaurantId))
                        .findFirst()
                        .orElse(null);
    }

    //Находим оценки ресторана по его ID для пересчёта средней оценки
    public List<Review> findByRestaurantId(Long restaurantId) {
        List<Review> result = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getRestaurantId().equals(restaurantId)) {
                result.add(review);
            }
        }
        return result;
    }

}

