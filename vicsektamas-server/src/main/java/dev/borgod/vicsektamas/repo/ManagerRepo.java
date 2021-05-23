package dev.borgod.vicsektamas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.borgod.vicsektamas.model.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Long> {
    
}
