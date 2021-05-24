package dev.borgod.vicsektamas.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDTO extends UserDTO {
    
    private List<ServiceDTO> services;
}
