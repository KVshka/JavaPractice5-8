package com.example.restaurantsproject.repositories;

import com.example.restaurantsproject.entities.Rate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RatingRepository {
    private final List<Rate> ratings = new ArrayList<>();

    public void save(Rate rating) {
        ratings.add(rating);
    }

    public void remove(Rate rating) {
        ratings.remove(rating);
    }

    public List<Rate> findAll() {
        return new ArrayList<>(ratings);
    }

    public Optional<Rate> findById(Long guestId, Long restaurantId) {
        return ratings.stream()
                .filter(r -> r.getGuestId().equals(guestId) && r.getRestaurantId().equals(restaurantId))
                .findFirst();
    }

    //Находим оценки ресторана по его ID для пересчёта средней оценки
    public List<Rate> findByRestaurantId(Long restaurantId) {
        List<Rate> result = new ArrayList<>();
        for (Rate rating : ratings) {
            if (rating.getRestaurantId().equals(restaurantId)) {
                result.add(rating);
            }
        }
        return result;
    }
}

