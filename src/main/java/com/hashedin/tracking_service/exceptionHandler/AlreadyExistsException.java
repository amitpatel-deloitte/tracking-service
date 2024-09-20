package com.hashedin.tracking_service.exceptionHandler;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message){
        super(message);
    }
}
