package com.parkingsystem.parking.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  @author Sunny Ansal
 *  */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Vehicle")
public class Vehicle {

    @Id
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
}
