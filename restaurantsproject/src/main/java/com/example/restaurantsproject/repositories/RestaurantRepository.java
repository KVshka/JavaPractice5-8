package com.example.restaurantsproject.repositories;

import com.example.restaurantsproject.entities.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepository {
    private final List<Restaurant> restaurants = new ArrayList<>();

    public void save(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void remove(Long id) {
        restaurants.removeIf(r -> r.getId().equals(id));
    }

    public void update(Long id, Restaurant restaurant){
        remove(id);
        save(restaurant);
    }

    public List<Restaurant> findAll() {
        return new ArrayList<>(restaurants);
    }

    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Long nextId(){
        if (restaurants.isEmpty()){
            return 1L;
        } else {
            return restaurants.get(restaurants.size() - 1).getId() + 1L;
        }
    }
}

