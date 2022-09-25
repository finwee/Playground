package com.hubertdostal.tmobile.homework.exception;

public class UserNotFoundException extends Exception {

    private final Long notFoundId;

    private final String fieldName;

    public UserNotFoundException(Long notFoundId, String fieldName) {
        super("User not found by field: " + fieldName + " value: " + notFoundId);
        this.notFoundId = notFoundId;
        this.fieldName = fieldName;
    }

    public Long getNotFoundId() {
        return notFoundId;
    }

    public String getFieldName() {
        return fieldName;
    }
}
