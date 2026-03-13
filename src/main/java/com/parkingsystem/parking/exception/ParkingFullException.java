package com.parkingsystem.parking.exception;


/**
 *
 * @author sunny.ansal
 */


public class ParkingFullException extends RuntimeException{
    public ParkingFullException(String message){
        super(message);
    }

}
