package dev.borgod.vicsektamas.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dev.borgod.vicsektamas.api.dto.ServiceDTO;
import dev.borgod.vicsektamas.exception.ResourceNotFoundException;
import dev.borgod.vicsektamas.model.Service;
import dev.borgod.vicsektamas.repo.ManagerRepo;

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
        dto.setReservations(reservationMapper.createDTOList(model.getReservations()));
        return dto;
    }

    @Override
    public Service createModel(ServiceDTO dto) {
        var model = modelMapper.map(dto, Service.class);
        model.setOwner(managerRepo.findById(dto.getOwnerId()).orElseThrow(ResourceNotFoundException::new));
        model.setReservations(reservationMapper.createModelList(dto.getReservations()));
        return model;
    }
    
}
