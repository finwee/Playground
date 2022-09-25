package com.hubertdostal.tmobile.homework.repository;

import com.hubertdostal.tmobile.homework.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
