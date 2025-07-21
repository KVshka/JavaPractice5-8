package com.example.restaurantsproject.dto;

import java.math.BigDecimal;

public record RestaurantResponseDTO(Long id,
                                    String name,
                                    String description,
                                    String cuisine,
                                    double averageCheck,
                                    BigDecimal guestRate) {};
