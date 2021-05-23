package dev.borgod.vicsektamas.api.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
    
    private Long customerId;
    private Long serviceId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
