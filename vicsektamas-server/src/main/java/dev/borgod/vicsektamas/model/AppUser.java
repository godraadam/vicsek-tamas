package dev.borgod.vicsektamas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUser extends BaseModel {
    
    private String username;
    private String password;
    private String email;
}
