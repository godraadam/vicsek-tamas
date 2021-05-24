package dev.borgod.vicsektamas.api.dto;

import java.util.List;

import org.springframework.lang.Nullable;

import dev.borgod.vicsektamas.model.TimeTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {
    private Long id;
    private String title;
    private String description;
    private Long ownerId;
    private @Nullable TimeTable activeTimeTable;
    private List<ReservationDTO> reservations;
}
