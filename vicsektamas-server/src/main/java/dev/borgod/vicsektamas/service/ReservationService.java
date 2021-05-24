package dev.borgod.vicsektamas.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.model.Reservation;
import dev.borgod.vicsektamas.repo.ReservationRepo;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    @PostConstruct
    public void init() {
        listeners = new ArrayList<>();
        addListener(new MailSenderService());
        addListener(new MessageSenderService());
    }


    private List<MadeReservationListener> listeners;

    public Reservation saveReservation(Reservation reservation) {

        //notify listeners
        listeners.forEach(l -> l.onReservationMade(reservation));
        return reservationRepo.save(reservation);
    }

    public void addListener(MadeReservationListener mrl) {
        listeners.add(mrl);
    }

    public void removeListener(MadeReservationListener mrl) {
        listeners.remove(mrl);
    }

}
