package dev.borgod.vicsektamas.api.controller;

import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.borgod.vicsektamas.api.dto.ServiceDTO;
import dev.borgod.vicsektamas.api.mapper.ServiceMapper;
import dev.borgod.vicsektamas.exception.ResourceNotFoundException;
import dev.borgod.vicsektamas.repo.ServiceRepo;

@RestController
public class ServiceController {
    
    @Autowired
    private ServiceRepo serviceRepo;

    @Autowired
    private ServiceMapper serviceMapper;


    @GetMapping("/api/service/{id}")
    public ServiceDTO getServiceById(@PathVariable Long id) {
        var service = serviceRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        return serviceMapper.createDTO(service);
    }

    @GetMapping("/api/service/{title}}")
    public List<ServiceDTO> getServiceByTitle(@PathVariable String title) {
        var services = serviceRepo.findByTitle(title);
        return serviceMapper.createDTOList(services);
    }

    @PostMapping("/manager/api/service")
    public ServiceDTO createService(@RequestBody ServiceDTO dto) {
        var service = serviceMapper.createModel(dto);
        service.setTimeTables(Collections.emptyList());
        service.setReservations(Collections.emptyList());
        return serviceMapper.createDTO(serviceRepo.save(service));
    }

    @PutMapping("/manager/api/service")
    public ServiceDTO editService(@RequestBody ServiceDTO dto) {
        return serviceMapper.createDTO(serviceRepo.save(serviceMapper.createModel(dto)));
    }

    @DeleteMapping("/manager/api/service/{id}")
    public void deleteServiceById(@PathVariable Long id) {
        serviceRepo.deleteById(id);
    }

}
