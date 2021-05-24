package dev.borgod.vicsektamas.api.dto;

import java.util.List;

import dev.borgod.vicsektamas.model.TimeTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {
    private String name;
    private String description;
    private Long ownerId;
    private TimeTable activeTimeTable;
    private List<ReservationDTO> reservations;
}
