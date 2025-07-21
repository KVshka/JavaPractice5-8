package com.example.restaurantsproject.entities;

import com.example.restaurantsproject.enums.Cuisines;

import java.math.BigDecimal;

public class Restaurant {

    private Long id;

    private String Name;

    private String Description = null;

    private String Cuisine;

    private double AverageCheck;

    private BigDecimal GuestRate = BigDecimal.ZERO;

    public Restaurant(Long id, String Name, String Description, Cuisines Cuisine, double AverageCheck) {
        this.id = id;
        this.Name = Name;
        this.Description = Description;
        this.Cuisine = Cuisine.getCuisine();
        this.AverageCheck = AverageCheck;
    }

    public Long getId(){ return this.id; }
    public String getName(){ return this.Name; }
    public String getDescription(){ return this.Description; }
    public String getCuisine(){ return this.Cuisine; }
    public double getAverageCheck(){ return this.AverageCheck; }
    public BigDecimal getGuestRate(){ return this.GuestRate; }


    public void setRate(BigDecimal guestRate) { this.GuestRate = guestRate; }
    public void setId(Long id) { this.id = id; }
}
