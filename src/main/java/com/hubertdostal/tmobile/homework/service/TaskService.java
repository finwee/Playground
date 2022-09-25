package com.hubertdostal.tmobile.homework.service;

import com.hubertdostal.tmobile.homework.exception.TaskNotFoundException;
import com.hubertdostal.tmobile.homework.exception.UserNotFoundException;
import com.hubertdostal.tmobile.homework.model.Task;
import com.hubertdostal.tmobile.homework.model.dto.TaskDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface TaskService {

    TaskDTO createNewTask(@Valid @NotNull final TaskDTO taskDTO) throws UserNotFoundException;

    TaskDTO updateTask(@Valid @NotNull final TaskDTO taskDTO) throws TaskNotFoundException, UserNotFoundException;

    List<TaskDTO> getTasksByAcquiredBy(@NotNull final Long acquiredBy);

    List<TaskDTO> getTasksByUserNote(@NotNull final String userNote);

}
