package com.hubertdostal.tmobile.homework.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * POJO model entity class representing task
 */
@Entity(name = "Task")
@Table(name = "TASKS", schema = "SCHEMA2")
public class Task {
    /**
     * Unique identifier of instance of Task
     * Its value is automatically generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_")
    private Long id;

    @Column(name = "USER_NOTE_", length=255)
    private String userNote;

    @Column(name = "TASK_DATA_")
    private String taskData;

    @ManyToOne(optional = false)
    @JoinColumn(name="ACQUIRED_BY_", nullable=false)
    private User acquiredByUser;

    @ManyToOne
    @JoinColumn(name="CREATED_BY_", nullable=false)
    private User createdByUser;

    public Task() {
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

    public User getAcquiredByUser() {
        return acquiredByUser;
    }

    public void setAcquiredByUser(User acquiredByUser) {
        this.acquiredByUser = acquiredByUser;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(User createdByUser) {
        this.createdByUser = createdByUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return Objects.equals(getId(), task.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", acquiredByUser=" + acquiredByUser.getId() +
                ", createdByUser=" + createdByUser.getId() +
                '}';
    }
}
