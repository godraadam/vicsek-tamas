package dev.borgod.vicsektamas.model;

import java.time.LocalTime;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class TimeTableSlot {
    
    private LocalTime startTime;
    private LocalTime endTime;
    private Long maxCustomerCount;
}
