package dev.borgod.vicsektamas.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
