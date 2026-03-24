package com.parkingsystem.parking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExitParkingResponse {

    private Long ticketId;

    private double price;

    private String vehicleNumber;

    private Long slotId;

    private Long duration;

    private String message;

    private LocalDateTime exitTime;
}
