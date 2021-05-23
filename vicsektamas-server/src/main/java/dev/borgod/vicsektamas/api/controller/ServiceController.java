package dev.borgod.vicsektamas.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.borgod.vicsektamas.api.dto.ServiceDTO;
import dev.borgod.vicsektamas.model.Service;
import dev.borgod.vicsektamas.repo.ServiceRepo;

@RestController
public class ServiceController {
    
    @Autowired
    private ServiceRepo serviceRepo;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/api/service/{id}")
    public ServiceDTO getServiceById(@PathVariable Long id) {
        var service = serviceRepo.findById(id);
        return modelMapper.map(service, ServiceDTO.class);
    }

    @GetMapping("/api/service/{title}}")
    public ServiceDTO getServiceByTitle(@PathVariable String title) {
        var service = serviceRepo.findByTitle(title);
        return modelMapper.map(service, ServiceDTO.class);
    }

    @PostMapping("/api/service")
    public ServiceDTO createService(ServiceDTO dto) {
        var service = serviceRepo.save(modelMapper.map(dto, Service.class));
        return modelMapper.map(service, ServiceDTO.class);
    }

    @PutMapping("/api/service")
    public ServiceDTO editService(ServiceDTO dto) {
        return createService(dto);
    }

    @DeleteMapping("/api/service/{id}")
    public void deleteServiceById(@PathVariable Long id) {
        serviceRepo.deleteById(id);
    }

}
