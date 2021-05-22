package dev.borgod.vicsektamas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends AppUser {
    
    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;
}
