package dev.borgod.vicsektamas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.borgod.vicsektamas.model.Service;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> {
    List<Service> findByTitle(String name);
}
