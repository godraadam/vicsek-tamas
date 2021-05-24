package dev.borgod.vicsektamas.service;

import dev.borgod.vicsektamas.model.Reservation;

public interface MadeReservationListener {
    void onReservationMade(Reservation reservation);
}
