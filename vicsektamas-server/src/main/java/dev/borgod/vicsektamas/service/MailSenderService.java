package dev.borgod.vicsektamas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.model.Reservation;

@Service
public class MailSenderService implements MadeReservationListener {

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
        jms.send(msg);
    }

}
