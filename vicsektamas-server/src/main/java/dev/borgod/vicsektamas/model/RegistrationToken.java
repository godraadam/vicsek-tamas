package dev.borgod.vicsektamas.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "registration_tokens")
public class RegistrationToken extends BaseModel {
    
    private String token;
    private LocalDateTime timeStamp;
}
