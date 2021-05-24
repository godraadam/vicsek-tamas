package dev.borgod.vicsektamas.service;

import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.model.Reservation;
import lombok.extern.log4j.Log4j2;


// Just demonstration for Observer pattern, no actual implementation here
@Log4j2
@Service
public class MessageSenderService implements MadeReservationListener, CommunicationService {

    @Override
    public void onReservationMade(Reservation reservation) {
        //send message and stuff
        log.info("Message was sent to " + reservation.getCustomer().getPhoneNumber());
    }

    @Override
    public void accept(CommunicationServiceVisitor csv) {
        csv.visit(this);
        
    }
    
}
