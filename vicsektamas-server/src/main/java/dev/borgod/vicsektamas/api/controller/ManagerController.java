package dev.borgod.vicsektamas.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.borgod.vicsektamas.api.dto.ManagerDTO;
import dev.borgod.vicsektamas.api.dto.ManagerRegisterDTO;
import dev.borgod.vicsektamas.api.mapper.ManagerMapper;
import dev.borgod.vicsektamas.model.Manager;
import dev.borgod.vicsektamas.model.RegistrationToken;
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
    public ManagerDTO registerManager(@RequestBody ManagerRegisterDTO dto) {
        System.out.println(dto.getUsername());
        var manager = modelMapper.map(dto, Manager.class);
        System.out.println(manager.getUsername());
        var tokenDTO = dto.getTokenDTO();
        return managerMapper.createDTO(managerService.registerManager(manager, modelMapper.map(tokenDTO, RegistrationToken.class)));
    }

    @DeleteMapping("/admin/api/manager/{id}") 
    public void removeManager(@PathVariable Long id) {
        managerRepo.deleteById(id);
    }
}
