package dev.borgod.vicsektamas.dto;

import dev.borgod.vicsektamas.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private Role role;

    private boolean emailVerified;
    private boolean phoneNumberVerified;
    
}
