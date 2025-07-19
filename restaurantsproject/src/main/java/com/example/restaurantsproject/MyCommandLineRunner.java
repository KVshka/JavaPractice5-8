package com.example.restaurantsproject;

import com.example.restaurantsproject.entities.*;
import com.example.restaurantsproject.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private final GuestService guestService;
    private final RestaurantService restaurantService;
    private final RatingService ratingService;

    public MyCommandLineRunner(GuestService guestService, RestaurantService restaurantService, RatingService ratingService) {
        this.guestService = guestService;
        this.restaurantService = restaurantService;
        this.ratingService = ratingService;
    }

    @Override
    public void run(String... args) {
        System.out.println("ВСЕ ПОСЕТИТЕЛИ");
        for (Guest g : guestService.findAll()) {
            System.out.printf("ID: %d, Имя: %s, Возраст: %d, Пол: %s%n", g.getId(), g.getName(), g.getAge(), g.getGender());
        }

        System.out.println("\nВСЕ РЕСТОРАНЫ");
        for (Restaurant r : restaurantService.findAll()) {
            System.out.printf("ID: %d, Название: %s, Тип кухни: %s, Средний чек: %s, Рейтинг: %.2f%nОписание:%s%n", r.getId(), r.getName(),
                    r.getCuisine(), r.getAverageCheck(), r.getGuestRate(), r.getDescription() != null ? r.getDescription() : "(Нет описания)");
        }

        System.out.println("\nВСЕ ОЦЕНКИ");
        for (Rate rating : ratingService.findAll()) {
            System.out.printf("Гость ID: %d, Ресторан ID: %d, Оценка: %d, Отзыв: %s%n",
                    rating.getGuestId(), rating.getRestaurantId(), rating.getScore(), rating.getReviewText());
        }
    }
}

