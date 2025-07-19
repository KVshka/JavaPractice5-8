package com.example.restaurantsproject.init;

import com.example.restaurantsproject.entities.*;
import com.example.restaurantsproject.enums.Cuisines;
import com.example.restaurantsproject.services.*;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class DataInit {

    private final GuestService guestService;
    private final RestaurantService restaurantService;
    private final RatingService ratingService;

    public DataInit(GuestService guestService, RestaurantService restaurantService, RatingService ratingService) {
        this.guestService = guestService;
        this.restaurantService = restaurantService;
        this.ratingService = ratingService;
    }

    @PostConstruct
    public void initData() {

        guestService.save(new Guest(1L, "Анна", 29, "Ж"));
        guestService.save(new Guest(2L, "Николай", 33, "М")); // аноним
        guestService.save(new Guest(3L, "Дмитрий", 40, "М"));
        guestService.save(new Guest(4L, "Мария", 27, "Ж"));
        guestService.save(new Guest(5L, "Алексей", 35, "М")); // аноним

        restaurantService.save(new Restaurant(1L, "Вепрево Колено", "Хорошечная кухня в лучших традициях чешской культуры", Cuisines.EUROPEAN, 2000));
        restaurantService.save(new Restaurant(2L, "Перчини", "Итальянская кухня", Cuisines.ITALIAN, 1600));
        restaurantService.save(new Restaurant(3L, "Феникс", "Модное и красивое место с оригинальной Китайской кухней", Cuisines.CHINESE, 850));

        ratingService.save(new Rate(1L, 1L, 5, "Отличный выбор блюд!"));
        ratingService.save(new Rate(3L, 1L, 3, "Не очень"));
        ratingService.save(new Rate(2L, 1L, 5, "Отличное заведение с хорошими официантами"));
        ratingService.save(new Rate(4L, 2L, 5, "Отличное заведение с хорошими официантами"));
        ratingService.save(new Rate(2L, 2L, 4, "Уютная атмосфера, рекомендую"));
        ratingService.save(new Rate(3L, 3L, 5, "Отличный выбор блюд!"));
        ratingService.save(new Rate(5L, 3L, 4, "Уютная атмосфера, рекомендую"));

    }
}
