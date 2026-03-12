package com.parkingsystem.parking.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  @author Sunny Ansal
 *  */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ParkingSlot")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int floorNumber;

    private boolean occupied;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String vehicleNumber;
}
