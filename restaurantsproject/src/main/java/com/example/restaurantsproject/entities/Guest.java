package com.example.restaurantsproject.entities;

public class Guest {

    private Long id;

    private String Name; // optional

    private int Age;

    private String Gender;

    public Guest(Long id, String Name, int Age, String Gender) {
        this.id = id;
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
    }

    public Long getId() { return this.id; }
    public String getName() { return this.Name; }
    public int getAge() { return this.Age; }
    public String getGender() { return this.Gender; }

}
