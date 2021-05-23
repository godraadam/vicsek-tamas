package dev.borgod.vicsektamas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.borgod.vicsektamas.model.TimeTable;

public interface TimeTableRepo extends JpaRepository<TimeTable, Long> {
    
    List<TimeTable> findByServiceId(Long id);

}
