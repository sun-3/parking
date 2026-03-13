package com.parkingsystem.parking.exception;


/**
 *
 * @author sunny.ansal
 */

public class TicketNotFoundException extends RuntimeException{

    public TicketNotFoundException(String message){
        super(message);
    }
}
