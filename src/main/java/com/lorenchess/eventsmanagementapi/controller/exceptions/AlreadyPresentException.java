package com.lorenchess.eventsmanagementapi.controller.exceptions;

public class AlreadyPresentException extends RuntimeException {
   public AlreadyPresentException(String errorMessage, Throwable error) {
       super(errorMessage, error);
   }
}
