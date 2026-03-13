package com.parkingsystem.parking.exception;


/**
 *
 * @author sunny.ansal
 */

public class SlotNotFoundException extends RuntimeException {

    public SlotNotFoundException(String message){
        super(message);
    }
}
