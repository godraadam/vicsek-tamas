package dev.borgod.vicsektamas.model;

import java.util.Collections;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "timetables")
public class TimeTable extends BaseModel {
    
    private String name;

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID")
    private Service service;
    
    @ElementCollection
    private List<TimeTableSlot> mondaySlots = Collections.emptyList();
    @ElementCollection
    private List<TimeTableSlot> tuesdaySlots = Collections.emptyList();
    @ElementCollection
    private List<TimeTableSlot> wednesdaySlots = Collections.emptyList();
    @ElementCollection
    private List<TimeTableSlot> thursdaySlots = Collections.emptyList();
    @ElementCollection
    private List<TimeTableSlot> fridaySlots = Collections.emptyList();
    @ElementCollection
    private List<TimeTableSlot> saturdaySlots = Collections.emptyList();
    @ElementCollection
    private List<TimeTableSlot> sundaySlots = Collections.emptyList();
}
