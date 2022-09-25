package com.hubertdostal.tmobile.homework.exception;

public class TaskNotFoundException extends Throwable {
    private final Long notFoundId;

    public TaskNotFoundException(Long notFoundId) {
        super("Task not found for ID : " + notFoundId);
        this.notFoundId = notFoundId;
    }

    public Long getNotFoundId() {
        return notFoundId;
    }
}
