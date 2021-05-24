package dev.borgod.vicsektamas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.borgod.vicsektamas.model.Manager;
@Repository
public interface ManagerRepo extends JpaRepository<Manager, Long> {
    
}
