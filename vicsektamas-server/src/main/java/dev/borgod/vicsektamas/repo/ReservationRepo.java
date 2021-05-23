package dev.borgod.vicsektamas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.borgod.vicsektamas.model.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomerId(Long id);
    List<Reservation> findByServiceId(Long id);
}
