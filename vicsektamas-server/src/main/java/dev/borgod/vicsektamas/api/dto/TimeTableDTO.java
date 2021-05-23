package dev.borgod.vicsektamas.api.dto;

import java.util.Collections;
import java.util.List;

import dev.borgod.vicsektamas.model.TimeTableSlot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeTableDTO {
    
    private String name;
    private Long serviceId;
    
    private List<TimeTableSlot> mondaySlots = Collections.emptyList();
    private List<TimeTableSlot> tuesdaySlots = Collections.emptyList();
    private List<TimeTableSlot> wednesdaySlots = Collections.emptyList();
    private List<TimeTableSlot> thursdaySlots = Collections.emptyList();
    private List<TimeTableSlot> fridaySlots = Collections.emptyList();
    private List<TimeTableSlot> saturdaySlots = Collections.emptyList();
    private List<TimeTableSlot> sundaySlots = Collections.emptyList();

}
