package com.hubertdostal.tmobile.homework.controller;

import com.hubertdostal.tmobile.homework.exception.UserNotFoundException;
import com.hubertdostal.tmobile.homework.model.Task;
import com.hubertdostal.tmobile.homework.model.dto.TaskDTO;
import com.hubertdostal.tmobile.homework.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getHello() {
        return "Hello world!";
    }

    @PostMapping("/task")
    ResponseEntity<TaskDTO> saveNewTask(@Valid @RequestBody TaskDTO newTask) {
        //TODO validation here?
        try {
            return new ResponseEntity(taskService.createNewTask(newTask), HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
