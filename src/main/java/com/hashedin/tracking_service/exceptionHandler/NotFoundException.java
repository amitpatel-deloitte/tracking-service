package com.hashedin.tracking_service.exceptionHandler;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
