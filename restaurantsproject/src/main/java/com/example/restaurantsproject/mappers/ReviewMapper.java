package com.example.restaurantsproject.mappers;

import com.example.restaurantsproject.dto.ReviewRequestDTO;
import com.example.restaurantsproject.dto.ReviewResponseDTO;
import com.example.restaurantsproject.entities.Review;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

//Маппер для отзывов
@Component
public class ReviewMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    //Сущность в DTO
    public Review convertToEntity(ReviewRequestDTO requestDTO) {
        return modelMapper.map(requestDTO, Review.class);
    }

    //DTO в сущность
    public ReviewResponseDTO convertToDto(Review review) {
        return modelMapper.map(review, ReviewResponseDTO.class);
    }
}