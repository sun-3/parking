package com.parkingsystem.parking.service.implementation;

import com.parkingsystem.parking.model.ParkingSlot;
import com.parkingsystem.parking.model.Ticket;
import com.parkingsystem.parking.model.VehicleType;
import com.parkingsystem.parking.repository.ParkingSlotRepository;
import com.parkingsystem.parking.repository.TicketRepository;
import com.parkingsystem.parking.service.abstraction.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *  @author Sunny Ansal
 *  */

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public String parkVehicle(String vehicleNumber, VehicleType vehicleType) {
        ParkingSlot parkingSlot = parkingSlotRepository.findFirstByVehicleTypeAndOccupiedFalse(VehicleType.valueOf(vehicleType.name()))
                                                        .orElseThrow(()-> new RuntimeException("No slots available"));

        parkingSlot.setOccupied(true);
        parkingSlot.setVehicleNumber(vehicleNumber);
        parkingSlotRepository.save(parkingSlot);

        Ticket ticket = new Ticket();
        ticket.setVehicleNumber(vehicleNumber);
        ticket.setSlotId(parkingSlot.getId());
        ticket.setEntryTime(LocalDateTime.now());

        ticketRepository.save(ticket);
        return "vehicle parked . ticketId"+ticket.getId();
    }

    @Override
    public double exitParking(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();

        ticket.setExitTime(LocalDateTime.now());

        long hours = Duration.between(ticket.getEntryTime(),ticket.getExitTime()).toHours();

        double price = hours * 10;
        ticket.setPrice(price);
        ticketRepository.save(ticket);

        ParkingSlot parkingSlot = parkingSlotRepository.findById(ticket.getSlotId()).orElseThrow(() ->
                new RuntimeException("no slot available"));

        parkingSlot.setOccupied(false);
        parkingSlot.setVehicleNumber(null);
        parkingSlotRepository.save(parkingSlot);
        return price;
    }
}
