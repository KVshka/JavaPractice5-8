package com.example.restaurantsproject.controllers;

import com.example.restaurantsproject.dto.RestaurantRequestDTO;
import com.example.restaurantsproject.dto.RestaurantResponseDTO;
import com.example.restaurantsproject.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/restaurants")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @PostMapping
    public void newRestaurant(@RequestBody RestaurantRequestDTO dto){ service.save(dto); }

    @GetMapping
    public List<RestaurantResponseDTO> getAllRestaurants(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RestaurantResponseDTO getRestaurant(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public void updateRestaurant(@PathVariable Long id,
                            @RequestBody RestaurantRequestDTO dto){
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id){ service.remove(id); }

}
