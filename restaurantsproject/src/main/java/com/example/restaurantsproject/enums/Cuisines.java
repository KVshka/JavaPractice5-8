package com.example.restaurantsproject.enums;

public enum Cuisines {
    EUROPEAN("Европейская"),
    ITALIAN("Итальянская"),
    CHINESE("Китайская"),
    JAPANESE("Японская"),
    MEXICAN("Мексиканская");

    private final String cuisine;

    Cuisines(String cuisine) {this.cuisine = cuisine;}

    public String getCuisine() { return cuisine; }
}
