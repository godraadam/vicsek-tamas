package dev.borgod.vicsektamas.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

}
