package com.hubertdostal.tmobile.homework.service;

import com.hubertdostal.tmobile.homework.exception.UserNotFoundException;
import com.hubertdostal.tmobile.homework.model.Task;
import com.hubertdostal.tmobile.homework.model.dto.TaskDTO;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface TaskService {

    TaskDTO createNewTask(@NotNull TaskDTO taskDTO) throws UserNotFoundException;

    TaskDTO updateTask(@NotNull TaskDTO taskDTO);

    List<Task> getTasksByAcquiredBy(@NotNull Integer acquiredBy);

}
