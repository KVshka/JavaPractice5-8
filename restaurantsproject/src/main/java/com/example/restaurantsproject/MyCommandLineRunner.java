package com.example.restaurantsproject;

import com.example.restaurantsproject.entities.*;
import com.example.restaurantsproject.enums.Cuisines;
import com.example.restaurantsproject.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private final GuestService guestService;
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    public MyCommandLineRunner(GuestService guestService, RestaurantService restaurantService, ReviewService reviewService) {
        this.guestService = guestService;
        this.restaurantService = restaurantService;
        this.reviewService = reviewService;
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

        reviewService.save(new Review(1L, 1L, 5, "Отличный выбор блюд!"));
        reviewService.save(new Review(3L, 1L, 3, "Не очень"));
        reviewService.save(new Review(2L, 1L, 5, "Отличное заведение с хорошими официантами"));
        reviewService.save(new Review(4L, 2L, 5, "Отличное заведение с хорошими официантами"));
        reviewService.save(new Review(2L, 2L, 4, "Уютная атмосфера, рекомендую"));
        reviewService.save(new Review(3L, 3L, 5, "Отличный выбор блюд!"));
        reviewService.save(new Review(5L, 3L, 4, "Уютная атмосфера, рекомендую"));

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
        for (Review rating : reviewService.findAll()) {
            System.out.printf("Гость ID: %d, Ресторан ID: %d, Оценка: %d, Отзыв: %s%n",
                    rating.getGuestId(), rating.getRestaurantId(), rating.getScore(), rating.getReviewText());
        }
    }
}

