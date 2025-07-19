package com.example.restaurantsproject.repositories;

import com.example.restaurantsproject.entities.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestRepository {
    private final List<Guest> guests = new ArrayList<>();

    public void save(Guest guest) {
        guests.add(guest);
    }

    public void remove(Guest guest) {
        guests.remove(guest);
    }

    public List<Guest> findAll() {
        return new ArrayList<>(guests);
    }
}
