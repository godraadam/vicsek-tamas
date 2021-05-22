package dev.borgod.vicsektamas.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AppUser extends BaseModel {
    
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    private boolean emailVerified;
    private boolean phoneNumberVerified;
    private Role role;
}
