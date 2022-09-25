package com.hubertdostal.tmobile.homework.exception;

public class UserNotFoundException extends Exception {

    private Long idNotFound;

    private String fieldName;

    public UserNotFoundException(Long idNotFound, String fieldName) {
        super("User not found by field: " + fieldName + " value: " + idNotFound);
        this.idNotFound = idNotFound;
        this.fieldName = fieldName;
    }

    public Long getIdNotFound() {
        return idNotFound;
    }

    public String getFieldName() {
        return fieldName;
    }
}
