package com.example.restaurantsproject.mappers;

import com.example.restaurantsproject.dto.GuestRequestDTO;
import com.example.restaurantsproject.dto.GuestResponseDTO;
import com.example.restaurantsproject.entities.Guest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

//Маппер для гостей
@Component
public class GuestMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    //Сущность в DTO
    public Guest convertToEntity(GuestRequestDTO requestDTO, Long id) {
        Guest guest = modelMapper.map(requestDTO, Guest.class);
        guest.setId(id);
        return guest;
    }

    //DTO в сущность
    public GuestResponseDTO convertToDto(Guest guest) {
        return modelMapper.map(guest, GuestResponseDTO.class);
    }
}
