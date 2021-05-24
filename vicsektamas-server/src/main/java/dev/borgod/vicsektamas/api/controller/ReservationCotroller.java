package dev.borgod.vicsektamas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.borgod.vicsektamas.api.dto.ReservationDTO;
import dev.borgod.vicsektamas.api.mapper.ReservationMapper;
import dev.borgod.vicsektamas.exception.IncorrectCredentialsException;
import dev.borgod.vicsektamas.exception.ResourceNotFoundException;
import dev.borgod.vicsektamas.repo.ReservationRepo;

@RestController
public class ReservationCotroller {

    @Autowired
    private ReservationRepo reservationRepo;


    @Autowired
    private ReservationMapper reservationMapper;

    @GetMapping("/api/reservation/customer/{id}")
    public List<ReservationDTO> getReservationsForCustomer(@PathVariable Long id) {
        return reservationMapper.createDTOList(reservationRepo.findByCustomerId(id));
    }

    @GetMapping("/api/reservation/service/{id}")
    public List<ReservationDTO> getReservationsForService(@PathVariable Long id) {
        return reservationMapper.createDTOList(reservationRepo.findByServiceId(id));
    }

    @PostMapping("/api/reservation")
    public ReservationDTO makeReservation(@RequestBody ReservationDTO dto) {
        return reservationMapper.createDTO(reservationRepo.save(reservationMapper.createModel(dto)));
    }

    @PutMapping("/api/reservation/{id}")
    public ReservationDTO editReservation(@PathVariable Long id, @RequestBody ReservationDTO dto) {
        if(reservationRepo.findById(id).isEmpty()) throw new ResourceNotFoundException();
        var newReservation = reservationMapper.createModel(dto);
        newReservation.setId(id);
        return reservationMapper.createDTO(reservationRepo.save(newReservation));
    }

    @DeleteMapping("/api/reservation/cancel/{userId}/{reservationId}")
    public void cancelReservation(@PathVariable Long userId, @PathVariable Long reservationId) {
        if (!reservationRepo.findById(reservationId).orElseThrow(ResourceNotFoundException::new).getCustomer().getId().equals(userId)) {
            throw new IncorrectCredentialsException();
        }
        reservationRepo.deleteById(reservationId);
    }
}
