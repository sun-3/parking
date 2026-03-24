package com.parkingsystem.parking.dto;


import lombok.Data;

@Data
public class ParkingStatusResponse {

    private int totalFloors;

    private int totalSlots;

    private int occupiedSlots;

    private int availableSlots;
}
