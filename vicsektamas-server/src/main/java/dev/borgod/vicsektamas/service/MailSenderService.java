package dev.borgod.vicsektamas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.model.Reservation;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@Getter
public class MailSenderService implements MadeReservationListener, CommunicationService {

    @Autowired
    private JavaMailSender jms;

    @Override
    public void onReservationMade(Reservation reservation) {
        // could not make it work, sorry
        var msg = new SimpleMailMessage();
        msg.setFrom("noreply@borgod.com");
        msg.setTo(reservation.getCustomer().getEmail());
        msg.setSubject("Reservation succesful!");
        msg.setText("Thank you for using our service! Your reservation for " + reservation.getService().getTitle()
                + " has been succesfully created from " + reservation.getStartDateTime() + " to "
                + reservation.getEndDateTime() + "! have a great time!");
        //jms.send(msg);
        log.info("Mail was sent to " + reservation.getCustomer().getEmail());
    }

    @Override
    public void accept(CommunicationServiceVisitor csv) {
        csv.visit(this);
        
    }

}
