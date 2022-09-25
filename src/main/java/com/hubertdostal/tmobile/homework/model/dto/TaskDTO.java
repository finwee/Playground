package com.hubertdostal.tmobile.homework.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    //TODO hash and uquals


    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", acquiredByUserId=" + acquiredByUserId +
                ", createdByUserId=" + createdByUserId +
                '}';
    }
}
