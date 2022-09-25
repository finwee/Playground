package com.hubertdostal.tmobile.homework.service.impl;

import com.hubertdostal.tmobile.homework.exception.UserNotFoundException;
import com.hubertdostal.tmobile.homework.model.Task;
import com.hubertdostal.tmobile.homework.model.User;
import com.hubertdostal.tmobile.homework.model.dto.TaskDTO;
import com.hubertdostal.tmobile.homework.repository.TaskRepository;
import com.hubertdostal.tmobile.homework.repository.UserRepository;
import com.hubertdostal.tmobile.homework.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskDTO createNewTask(@NotNull TaskDTO taskDTO) throws UserNotFoundException {
        Optional<User> acquiredByUser = userRepository.findById(taskDTO.getAcquiredByUserId());
        if (acquiredByUser.isEmpty()) {
            throw new UserNotFoundException(taskDTO.getAcquiredByUserId(), "acquiredBy");
        }
        Optional<User> createdByUser = userRepository.findById(taskDTO.getCreatedByUserId());
        if (createdByUser.isEmpty()) {
            throw new UserNotFoundException(taskDTO.getCreatedByUserId(), "createdBy");
        }

        Task taskToSave = new Task();
        taskToSave.setUserNote(taskDTO.getUserNote());
        taskToSave.setTaskData(taskDTO.getTaskData());
        taskToSave.setAcquiredByUser(acquiredByUser.get());
        taskToSave.setCreatedByUser(createdByUser.get());

        Task savedTask = taskRepository.save(taskToSave);
        taskDTO.setId(savedTask.getId());

        return taskDTO;
    }

    @Override
    public TaskDTO updateTask(@NotNull TaskDTO taskDTO) {
        return null;
    }

    @Override
    public List<Task> getTasksByAcquiredBy(@NotNull Integer acquiredBy) {
        return null;
    }

}
