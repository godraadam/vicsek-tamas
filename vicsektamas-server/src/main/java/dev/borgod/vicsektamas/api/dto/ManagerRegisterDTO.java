package dev.borgod.vicsektamas.api.dto;

import dev.borgod.vicsektamas.model.RegistrationToken;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerRegisterDTO {
    
    private String password;
    private String email;
    private String username;
    private RegistrationToken token;
}
