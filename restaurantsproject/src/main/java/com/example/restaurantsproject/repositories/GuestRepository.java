package com.example.restaurantsproject.repositories;

import com.example.restaurantsproject.entities.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestRepository {
    private final List<Guest> guests = new ArrayList<>();

    public void save(Guest guest) { guests.add(guest); }

    public void remove(Long id) {
        guests.removeIf(g -> g.getId().equals(id));
    }

    public void update(Long id, Guest guest){
        remove(id);
        save(guest);
    }

    public List<Guest> findAll() {
        return new ArrayList<>(guests);
    }

    public Guest findById(Long id) {
        return guests.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Long nextId(){
        if (guests.isEmpty()){
            return 1L;
        } else {
            return guests.get(guests.size() - 1).getId() + 1L;
        }
    }
}
