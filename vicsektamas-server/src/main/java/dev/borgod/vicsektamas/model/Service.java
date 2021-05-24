package dev.borgod.vicsektamas.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "services")
public class Service extends BaseModel {
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Manager owner;

    private String title;
    private String description;
    private boolean verified;
    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "service")
    private List<TimeTable> timeTables;
    @OneToMany(mappedBy = "service")
    private List<Reservation> reservations;

    @OneToOne(optional = true)
    private TimeTable activeTimeTable;

}
