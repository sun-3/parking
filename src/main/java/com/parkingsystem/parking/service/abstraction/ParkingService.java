package com.parkingsystem.parking.service.abstraction;


import com.parkingsystem.parking.model.VehicleType;

/**
 *  @author Sunny Ansal
 *  */

public interface ParkingService {

    String parkVehicle(String vehicleNumber, VehicleType vehicleType);

    double exitParking(Long ticketId);
}
