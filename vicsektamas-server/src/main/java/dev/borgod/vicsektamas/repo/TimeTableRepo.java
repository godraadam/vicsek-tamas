package dev.borgod.vicsektamas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.borgod.vicsektamas.model.TimeTable;
@Repository
public interface TimeTableRepo extends JpaRepository<TimeTable, Long> {
    
    List<TimeTable> findByServiceId(Long id);

}
