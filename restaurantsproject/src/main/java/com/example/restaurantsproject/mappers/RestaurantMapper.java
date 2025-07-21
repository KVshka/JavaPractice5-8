package com.example.restaurantsproject.mappers;

import com.example.restaurantsproject.dto.RestaurantRequestDTO;
import com.example.restaurantsproject.dto.RestaurantResponseDTO;
import com.example.restaurantsproject.entities.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

//Маппер для ресторанов
@Component
public class RestaurantMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public Restaurant convertToEntity(RestaurantRequestDTO requestDTO, Long id) {
        Restaurant restaurant = modelMapper.map(requestDTO, Restaurant.class);
        restaurant.setId(id);
        return restaurant;
    }

    public RestaurantResponseDTO convertToDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantResponseDTO.class);
    }

}
