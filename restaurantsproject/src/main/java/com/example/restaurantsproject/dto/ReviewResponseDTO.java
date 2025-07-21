package com.example.restaurantsproject.dto;

public record ReviewResponseDTO(Long guestId, Long restarauntId, int score, String reviewText) {};
