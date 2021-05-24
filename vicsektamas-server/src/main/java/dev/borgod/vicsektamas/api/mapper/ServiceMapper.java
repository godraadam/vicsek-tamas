package dev.borgod.vicsektamas.api.mapper;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.borgod.vicsektamas.api.dto.ServiceDTO;
import dev.borgod.vicsektamas.exception.ResourceNotFoundException;
import dev.borgod.vicsektamas.model.Service;
import dev.borgod.vicsektamas.repo.ManagerRepo;

@Component
public class ServiceMapper implements GeneralMapper<ServiceDTO, Service> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private ManagerRepo managerRepo;

    @Override
    public ServiceDTO createDTO(Service model) {
        var dto = modelMapper.map(model, ServiceDTO.class);
        dto.setOwnerId(model.getOwner().getId());
        System.out.println(dto.getOwnerId());
        dto.setReservations(reservationMapper.createDTOList(model.getReservations()));
        return dto;
    }

    @Override
    public Service createModel(ServiceDTO dto) {
        var model = modelMapper.map(dto, Service.class);
        System.out.println(dto.getOwnerId());
        model.setOwner(managerRepo.findById(dto.getOwnerId()).orElseThrow(ResourceNotFoundException::new));
        model.setReservations(reservationMapper
                .createModelList(dto.getReservations() == null ? Collections.emptyList() : dto.getReservations()));
        return model;
    }

}
