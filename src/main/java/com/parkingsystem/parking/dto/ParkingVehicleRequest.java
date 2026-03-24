package com.parkingsystem.parking.dto;

import com.parkingsystem.parking.model.VehicleType;
import lombok.Data;

@Data
public class ParkingVehicleRequest {

    private String vehicleNumber;

    private VehicleType vehicleType;
}
