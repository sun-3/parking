package com.parkingsystem.parking.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 *  @author Sunny Ansal
 *  */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime entryTime;

    private Long slotId;

    private LocalDateTime exitTime;

    private String vehicleNumber;

    private double price;

    private Long floorNumber;
}
