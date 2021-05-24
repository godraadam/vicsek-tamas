package dev.borgod.vicsektamas.service;

import dev.borgod.vicsektamas.model.Reservation;


// Just demonstration for Observer pattern, no actual implementation here
public class MessageSenderService implements MadeReservationListener {

    @Override
    public void onReservationMade(Reservation reservation) {
        //send message and stuff
        
    }
    
}
