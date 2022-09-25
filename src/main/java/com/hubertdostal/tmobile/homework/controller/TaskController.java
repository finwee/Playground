package com.hubertdostal.tmobile.homework.controller;

import com.hubertdostal.tmobile.homework.exception.TaskNotFoundException;
import com.hubertdostal.tmobile.homework.exception.UserNotFoundException;
import com.hubertdostal.tmobile.homework.model.dto.TaskDTO;
import com.hubertdostal.tmobile.homework.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @PostMapping
    ResponseEntity<TaskDTO> saveNewTask(@Valid @RequestBody TaskDTO newTask) {
        try {
            return new ResponseEntity(taskService.createNewTask(newTask), HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @PutMapping
    ResponseEntity<TaskDTO> updateTask(@Valid @RequestBody TaskDTO newTask) {
        //TODO validation here?
        try {
            return new ResponseEntity(taskService.updateTask(newTask), HttpStatus.CREATED);
        } catch (TaskNotFoundException | UserNotFoundException e)  {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * GET method
     *
     * @param acquiredBy
     * @return
     */
    @GetMapping("/acquired_by/{acquiredBy}")
    ResponseEntity<List<TaskDTO>> findTasksForAcquiredBy(@PathVariable Long acquiredBy) {
        logger.info("Going to fetch tasks based on Acquired by value. Searched acquiredBy value: '{}'", acquiredBy);
        return new ResponseEntity<>(taskService.getTasksByAcquiredBy(acquiredBy), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<TaskDTO>> findTasksForAcquiredBy(@RequestParam String userNote) {
        logger.info("Going to fetch tasks based on User note fulltext search. Searched text: '{}'", userNote);
        return new ResponseEntity<>(taskService.getTasksByUserNote(userNote), HttpStatus.OK);
    }
}
