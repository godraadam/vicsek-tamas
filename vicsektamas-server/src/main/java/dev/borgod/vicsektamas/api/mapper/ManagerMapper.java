package dev.borgod.vicsektamas.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.borgod.vicsektamas.api.dto.ManagerDTO;
import dev.borgod.vicsektamas.model.Manager;
@Component
public class ManagerMapper implements GeneralMapper<ManagerDTO, Manager> {

    @Autowired
    private ServiceMapper serviceMapper;

    @Autowired
    private ModelMapper modelMapper;
    

    @Override
    public ManagerDTO createDTO(Manager model) {
        var dto = modelMapper.map(model, ManagerDTO.class);
        dto.setServices(serviceMapper.createDTOList(model.getServices()));
        return dto;
    }

    @Override
    public Manager createModel(ManagerDTO dto) {
        var model = modelMapper.map(dto, Manager.class);
        model.setServices(serviceMapper.createModelList(dto.getServices()));
        return model;
    }
    
}
