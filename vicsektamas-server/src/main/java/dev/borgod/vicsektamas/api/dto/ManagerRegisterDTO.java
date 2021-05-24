package dev.borgod.vicsektamas.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerRegisterDTO extends UserRegisterDTO {
    
    private RegistrationTokenDTO tokenDTO;
}
