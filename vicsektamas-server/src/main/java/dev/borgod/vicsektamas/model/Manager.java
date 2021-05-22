package dev.borgod.vicsektamas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "managers")
@Getter
@Setter
public class Manager extends AppUser {
    
    @OneToMany(mappedBy = "owner")
    private List<Service> services;

}
