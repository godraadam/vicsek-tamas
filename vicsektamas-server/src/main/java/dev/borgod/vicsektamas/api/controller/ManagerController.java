package dev.borgod.vicsektamas.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.borgod.vicsektamas.api.dto.ManagerDTO;
import dev.borgod.vicsektamas.api.dto.ManagerRegisterDTO;
import dev.borgod.vicsektamas.api.mapper.ManagerMapper;
import dev.borgod.vicsektamas.model.Manager;
import dev.borgod.vicsektamas.repo.ManagerRepo;
import dev.borgod.vicsektamas.service.ManagerService;

@RestController
public class ManagerController {
    
    @Autowired
    private ManagerService managerService;

    @Autowired 
    private ModelMapper modelMapper;

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private ManagerRepo managerRepo;

    @PostMapping("/register/manager")
    public ManagerDTO registerManager(ManagerRegisterDTO dto) {
        var manager = modelMapper.map(dto, Manager.class);
        var token = dto.getToken();
        return managerMapper.createDTO(managerService.registerManager(manager, token));
    }

    @DeleteMapping("/admin/api/manager") 
    public void removeManager(Long id) {
        managerRepo.deleteById(id);
    }
}
