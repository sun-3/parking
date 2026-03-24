package com.parkingsystem.parking.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketResponse {

    private Long tickedId;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private Long slotId;

    private Double price;

    private int floor;

    private String vehicleNumber;
}
