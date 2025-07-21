package com.example.restaurantsproject.services;

import com.example.restaurantsproject.dto.GuestRequestDTO;
import com.example.restaurantsproject.dto.GuestResponseDTO;
import com.example.restaurantsproject.entities.Guest;
import com.example.restaurantsproject.mappers.GuestMapper;
import com.example.restaurantsproject.repositories.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    public GuestService(GuestRepository guestRepository, GuestMapper guestMapper) {
        this.guestRepository = guestRepository;
        this.guestMapper = guestMapper;
    }

    public void save(GuestRequestDTO dto){
        Guest guest = guestMapper.convertToEntity(dto, guestRepository.nextId());
        guestRepository.save(guest);
    }

    public void remove(Long id) {
        guestRepository.remove(id);
    }

    public void update(Long id, GuestRequestDTO dto){
        Guest guest = guestMapper.convertToEntity(dto, guestRepository.nextId());
        guestRepository.update(id, guest);
    }

    public List<GuestResponseDTO> findAll() {
        List<GuestResponseDTO> dtoList = new ArrayList<>();
        for (Guest g : guestRepository.findAll()) {
            dtoList.add(guestMapper.convertToDto(g));
        }
        return dtoList;
    }

    public GuestResponseDTO findById(Long id) {
        Guest guest = guestRepository.findById(id);
        return guestMapper.convertToDto(guest);
    }
}

