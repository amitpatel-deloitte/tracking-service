package com.hashedin.tracking_service.exceptionHandler;

public class OrderNotPlaced extends RuntimeException{
    public OrderNotPlaced(String message){
        super(message);
    }
}
