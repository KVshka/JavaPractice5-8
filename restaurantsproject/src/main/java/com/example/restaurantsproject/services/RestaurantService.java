package com.example.restaurantsproject.services;

import com.example.restaurantsproject.dto.RestaurantRequestDTO;
import com.example.restaurantsproject.dto.RestaurantResponseDTO;
import com.example.restaurantsproject.entities.Restaurant;
import com.example.restaurantsproject.repositories.RestaurantRepository;
import com.example.restaurantsproject.mappers.RestaurantMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper){
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    public void save(RestaurantRequestDTO dto){
        Restaurant restaurant = restaurantMapper.convertToEntity(dto, restaurantRepository.nextId());
        restaurantRepository.save(restaurant);
    }

    public void remove(Long id) {
        restaurantRepository.remove(id);
    }

    public void update(Long id, RestaurantRequestDTO dto){
        Restaurant restaurant = restaurantMapper.convertToEntity(dto, restaurantRepository.nextId());
        restaurantRepository.update(id, restaurant);
    }

    public List<RestaurantResponseDTO> findAll() {
        List<RestaurantResponseDTO> dtoList = new ArrayList<>();
        for (Restaurant r : restaurantRepository.findAll()) {
            dtoList.add(restaurantMapper.convertToDto(r));
        }
        return dtoList;
    }

    public RestaurantResponseDTO findById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);
        return restaurantMapper.convertToDto(restaurant);
    }

    public void updateRating(Long restaurantId, double averageScore) {
        restaurantRepository.findAll().stream()
                .filter(r -> r.getId().equals(restaurantId))
                .findFirst()
                .ifPresent(r -> r.setRate(BigDecimal.valueOf(averageScore)));
    }
}

