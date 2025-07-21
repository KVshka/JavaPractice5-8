package com.example.restaurantsproject.entities;

public class Review {

    private Long GuestId;

    private Long RestaurantId;

    private int Score;

    private String ReviewText;

    public Review(Long GuestId, Long RestaurantId, int Score, String ReviewText) {
        this.GuestId = GuestId;
        this.RestaurantId = RestaurantId;
        this.Score = Score;
        this.ReviewText = ReviewText;
    }

    public Long getRestaurantId() { return this.RestaurantId; }
    public Long getGuestId() { return this.GuestId; }
    public int getScore() { return this.Score; }
    public String getReviewText() { return this.ReviewText; }
}
