package dev.borgod.vicsektamas.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class AppUser extends BaseModel {
    
    private String username;
    private String password;
    private String email;
}
