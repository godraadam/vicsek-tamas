package dev.borgod.vicsektamas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.borgod.vicsektamas.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    
}
