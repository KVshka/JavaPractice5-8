package com.example.restaurantsproject.services;

import com.example.restaurantsproject.entities.Guest;
import com.example.restaurantsproject.repositories.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public void save(Guest guest) {
        guestRepository.save(guest);
    }

    public void remove(Guest guest) {
        guestRepository.remove(guest);
    }

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }
}

