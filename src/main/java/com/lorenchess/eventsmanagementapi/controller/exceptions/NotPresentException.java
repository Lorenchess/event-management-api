package com.lorenchess.eventsmanagementapi.controller.exceptions;

public class NotPresentException extends RuntimeException{
    public NotPresentException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
