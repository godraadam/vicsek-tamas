package dev.borgod.vicsektamas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.borgod.vicsektamas.model.Reservation;
@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomerId(Long id);
    List<Reservation> findByServiceId(Long id);
}
