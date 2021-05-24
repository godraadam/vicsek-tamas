package dev.borgod.vicsektamas.api.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationTokenDTO {
    private String token;
    private LocalDateTime timeStamp;
}
