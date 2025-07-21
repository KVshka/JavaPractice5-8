package com.example.restaurantsproject.controllers;

import com.example.restaurantsproject.dto.GuestResponseDTO;
import com.example.restaurantsproject.dto.RestaurantResponseDTO;
import com.example.restaurantsproject.dto.ReviewRequestDTO;
import com.example.restaurantsproject.dto.ReviewResponseDTO;
import com.example.restaurantsproject.entities.Review;
import com.example.restaurantsproject.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping
    public void newReview(@RequestBody ReviewRequestDTO reviewDTO){
        service.save(reviewDTO);
    }

    @GetMapping
    public List<ReviewResponseDTO> getAllReviews(){
        return service.findAll();
    }

    @GetMapping("/{guestId}{restaurantId}")
    public ReviewResponseDTO getReview(@PathVariable("guestId") Long guestId,
                                     @PathVariable("restaurantId") Long restaurantId){
        return service.findById(guestId, restaurantId);
    }

    @PutMapping("/{guestId}{restaurantId}")
    public void updateReview(@PathVariable("guestId") Long guestId,
                             @PathVariable("restaurantId") Long restaurantId,
                             @RequestBody ReviewRequestDTO dto){
        service.update(guestId, restaurantId, dto);
    }

    @DeleteMapping("/{guestId}, {restaurantId}")
    public void deleteReview(@PathVariable Long guestId, Long restaurantId){ service.remove(guestId, restaurantId); }

}