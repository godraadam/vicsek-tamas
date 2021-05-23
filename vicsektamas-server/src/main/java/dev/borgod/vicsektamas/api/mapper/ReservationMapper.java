package dev.borgod.vicsektamas.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.borgod.vicsektamas.api.dto.ReservationDTO;
import dev.borgod.vicsektamas.exception.ResourceNotFoundException;
import dev.borgod.vicsektamas.model.Reservation;
import dev.borgod.vicsektamas.repo.CustomerRepo;
import dev.borgod.vicsektamas.repo.ServiceRepo;


@Component
public class ReservationMapper implements GeneralMapper<ReservationDTO, Reservation> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public ReservationDTO createDTO(Reservation model) {
        ReservationDTO dto = modelMapper.map(model, ReservationDTO.class);
        dto.setCustomerId(model.getCustomer().getId());
        dto.setServiceId(model.getService().getId());
        return dto;
    }

    @Override
    public Reservation createModel(ReservationDTO dto)  throws ResourceNotFoundException {
        Reservation model = modelMapper.map(dto, Reservation.class);
        model.setCustomer(customerRepo.findById(dto.getCustomerId()).orElseThrow(ResourceNotFoundException::new));
        model.setService(serviceRepo.findById(dto.getServiceId()).orElseThrow(ResourceNotFoundException::new));
        return model;
    }
    
}
