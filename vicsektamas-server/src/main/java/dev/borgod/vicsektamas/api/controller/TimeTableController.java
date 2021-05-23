package dev.borgod.vicsektamas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.borgod.vicsektamas.api.dto.TimeTableDTO;
import dev.borgod.vicsektamas.api.mapper.TimeTableMapper;
import dev.borgod.vicsektamas.exception.ResourceNotFoundException;
import dev.borgod.vicsektamas.repo.ServiceRepo;
import dev.borgod.vicsektamas.repo.TimeTableRepo;

@RestController
public class TimeTableController {

    @Autowired
    private TimeTableRepo timeTableRepo;

    @Autowired
    private TimeTableMapper timeTableMapper;

    @Autowired
    private ServiceRepo serviceRepo;
    
    @GetMapping("/api/timetable/service/all/{id}")
    public List<TimeTableDTO> getAllTimeTablesForService(@PathVariable Long id) {
        return timeTableMapper.createDTOList(timeTableRepo.findByServiceId(id));
    }

    @GetMapping("/api/timetable/service/active/{id}")
    public TimeTableDTO getActiveTimeTable(@PathVariable Long id) {
        return timeTableMapper.createDTO(serviceRepo.findById(id).orElseThrow(ResourceNotFoundException::new).getActiveTimeTable());
    }

    @PostMapping("/api/timetable/service/{id}")
    public TimeTableDTO createTimeTableForService(@PathVariable Long id, @RequestBody TimeTableDTO dto) {
        var service = serviceRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        var timeTable = timeTableMapper.createModel(dto);
        service.getTimeTables().add(timeTable);
        serviceRepo.save(service);
        return timeTableMapper.createDTO(timeTableRepo.save(timeTable));

    }

    @DeleteMapping("/api/timetable/{id}")
    public void deleteTimeTable(@PathVariable Long id) {
        var timeTable = timeTableRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        var service = timeTable.getService();
        service.getTimeTables().remove(timeTable);
        if (service.getActiveTimeTable().getId().equals(timeTable.getId())) {
            service.setActiveTimeTable(null);
        }
        serviceRepo.save(service);
        timeTableRepo.deleteById(id);
    }



}
