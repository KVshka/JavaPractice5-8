package com.example.restaurantsproject.controllers;

import com.example.restaurantsproject.dto.GuestRequestDTO;
import com.example.restaurantsproject.dto.GuestResponseDTO;
import com.example.restaurantsproject.services.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/guests")
public class GuestController {

    private final GuestService service;

    public GuestController(GuestService service) {
        this.service = service;
    }

    @PostMapping
    public void newGuest(@RequestBody GuestRequestDTO dto){ service.save(dto); }

    @GetMapping
    public List<GuestResponseDTO> getAllGuests(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GuestResponseDTO getGuest(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public void updateGuest(@PathVariable Long id,
                            @RequestBody GuestRequestDTO dto){
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id){ service.remove(id); }

}
