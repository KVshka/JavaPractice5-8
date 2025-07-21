package com.example.restaurantsproject.services;

import com.example.restaurantsproject.dto.ReviewRequestDTO;
import com.example.restaurantsproject.dto.ReviewResponseDTO;
import com.example.restaurantsproject.entities.Review;
import com.example.restaurantsproject.repositories.ReviewRepository;
import com.example.restaurantsproject.mappers.ReviewMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    private final RestaurantService restaurantService;

    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, RestaurantService restaurantService, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.restaurantService = restaurantService;
        this.reviewMapper = reviewMapper;
    }

    public void save(ReviewRequestDTO dto){
        Review review = reviewMapper.convertToEntity(dto);
        reviewRepository.save(review);
    }

    public void remove(Long guestId, Long restaurantId) {
        reviewRepository.remove(guestId, restaurantId);
        recalculateRestaurantRating(restaurantId);
    }

    public void update(Long guestId, Long restaurantID, ReviewRequestDTO dto){
        Review review = reviewMapper.convertToEntity(dto);
        reviewRepository.update(guestId, restaurantID, review);
    }

    public List<ReviewResponseDTO> findAll() {
        List<ReviewResponseDTO> dtoList = new ArrayList<>();
        for (Review r : reviewRepository.findAll()) {
            dtoList.add(reviewMapper.convertToDto(r));
        }
        return dtoList;
    }

    public ReviewResponseDTO findById(Long guestId, Long restaurantId) {
        Review review = reviewRepository.findById(guestId, restaurantId);
        return reviewMapper.convertToDto(review);
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
