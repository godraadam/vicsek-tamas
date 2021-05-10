package dev.borgod.vicsektamas.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class Customer extends AppUser {
    
}