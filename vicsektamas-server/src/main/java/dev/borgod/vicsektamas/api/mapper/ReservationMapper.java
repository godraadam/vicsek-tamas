package dev.borgod.vicsektamas.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.borgod.vicsektamas.api.dto.ReservationDTO;
import dev.borgod.vicsektamas.exception.ResourceNotFoundException;
import dev.borgod.vicsektamas.model.Reservation;
import dev.borgod.vicsektamas.repo.ServiceRepo;
import dev.borgod.vicsektamas.repo.UserRepo;


@Component
public class ReservationMapper implements GeneralMapper<ReservationDTO, Reservation> {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public ReservationDTO createDTO(Reservation model) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(model.getId());
        dto.setEndDateTime(model.getEndDateTime());
        dto.setStartDateTime(model.getStartDateTime());
        dto.setCustomerId(model.getCustomer().getId());
        dto.setServiceId(model.getService().getId());
        return dto;
    }

    @Override
    public Reservation createModel(ReservationDTO dto)  throws ResourceNotFoundException {
        Reservation model = new Reservation();
        model.setEndDateTime(dto.getEndDateTime());
        model.setStartDateTime(dto.getStartDateTime());
        model.setCustomer(userRepo.findById(dto.getCustomerId()).orElseThrow(ResourceNotFoundException::new));
        model.setService(serviceRepo.findById(dto.getServiceId()).orElseThrow(ResourceNotFoundException::new));
        return model;
    }
    
}
