package dev.borgod.vicsektamas.model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Contact {
    private String email;
    private String phoneNumber;
    private String website;
}
