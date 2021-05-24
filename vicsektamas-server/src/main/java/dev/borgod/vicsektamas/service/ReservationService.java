package dev.borgod.vicsektamas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.model.Reservation;
import dev.borgod.vicsektamas.repo.ReservationRepo;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;
    
    private List<MadeReservationListener> listeners;

    public Reservation saveReservation(Reservation reservation) {

        //notify listeners
        listeners.forEach(l -> l.onReservationMade(reservation));
        return reservationRepo.save(reservation);
    }

}
