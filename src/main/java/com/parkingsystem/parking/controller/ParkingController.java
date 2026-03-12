package com.parkingsystem.parking.controller;

import com.parkingsystem.parking.model.VehicleType;
import com.parkingsystem.parking.service.abstraction.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @author Sunny Ansal
 *
 *  */

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("/park")
    public String parkVehicle(@RequestParam String vehicleNumber, @RequestParam VehicleType vehicleType){
        return parkingService.parkVehicle(vehicleNumber,vehicleType);
    }

    @PostMapping("/exit")
    public double exitVehicle(@RequestParam Long ticketId){

        return parkingService.exitParking(ticketId);
    }
}
