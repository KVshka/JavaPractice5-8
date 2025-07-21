package com.example.restaurantsproject.dto;

import com.example.restaurantsproject.enums.Cuisines;

import java.math.BigDecimal;

public record RestaurantRequestDTO(String name,
                                   String description,
                                   Cuisines cuisine,
                                   double averageCheck,
                                   BigDecimal guestRate) {};

