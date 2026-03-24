package com.parkingsystem.parking.dto;

import com.parkingsystem.parking.model.VehicleType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingVehicleResponse {

    private String vehicleNumber;

    private VehicleType vehicleType;

    private LocalDateTime entryTime;

    private String message;

    private int floor;

    private Long slotId;

}
