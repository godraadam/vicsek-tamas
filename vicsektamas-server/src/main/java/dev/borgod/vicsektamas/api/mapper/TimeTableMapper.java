package dev.borgod.vicsektamas.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.borgod.vicsektamas.api.dto.TimeTableDTO;
import dev.borgod.vicsektamas.exception.ResourceNotFoundException;
import dev.borgod.vicsektamas.model.TimeTable;
import dev.borgod.vicsektamas.repo.ServiceRepo;
@Component
public class TimeTableMapper implements GeneralMapper<TimeTableDTO, TimeTable> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public TimeTableDTO createDTO(TimeTable model) {
        var dto = modelMapper.map(model, TimeTableDTO.class);
        dto.setServiceId(model.getService().getId());
        return dto;
    }

    @Override
    public TimeTable createModel(TimeTableDTO dto) {
        var model = modelMapper.map(dto, TimeTable.class);
        model.setService(serviceRepo.findById(dto.getServiceId()).orElseThrow(ResourceNotFoundException::new));
        return model;
    }
    
}
