package com.hubertdostal.tmobile.homework.model.dto;

import com.hubertdostal.tmobile.homework.model.Task;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class TaskDTO {
    private Long id;

    @NotEmpty(message = "${validation.task.userNoteEmpty}")
    @Size(max = 255, message = "${validation.task.userNoteTooLong}")
    private String userNote;

    @NotEmpty()
    private String taskData;

    @NotNull
    private Long acquiredByUserId;

    @NotNull
    private Long createdByUserId;

    public TaskDTO() {
    }

    public TaskDTO(Task task){
        this.id = task.getId();
        this.taskData = task.getTaskData();
        this.userNote = task.getUserNote();
        this.acquiredByUserId = task.getAcquiredByUser() != null ? task.getAcquiredByUser().getId() : null;
        this.createdByUserId = task.getCreatedByUser() != null ? task.getAcquiredByUser().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public String getTaskData() {
        return taskData;
    }

    public void setTaskData(String taskData) {
        this.taskData = taskData;
    }

    public Long getAcquiredByUserId() {
        return acquiredByUserId;
    }

    public void setAcquiredByUserId(Long acquiredByUserId) {
        this.acquiredByUserId = acquiredByUserId;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskDTO taskDto = (TaskDTO) o;

        return Objects.equals(getId(), taskDto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", acquiredByUserId=" + acquiredByUserId +
                ", createdByUserId=" + createdByUserId +
                '}';
    }
}
