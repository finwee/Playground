package com.hubertdostal.tmobile.homework.repository;

import com.hubertdostal.tmobile.homework.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "select * from SCHEMA2.TASKS t where t.ACQUIRED_BY_=:acquiredBy", nativeQuery = true)
    List<Task> findByAcquiredBy(Long acquiredBy);

    List<Task> findByUserNoteContaining(String userNote);
}
