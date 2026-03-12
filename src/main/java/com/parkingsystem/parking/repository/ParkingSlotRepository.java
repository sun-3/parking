package com.parkingsystem.parking.repository;

import com.parkingsystem.parking.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *  @author Sunny Ansal
 *  */

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

    Optional<ParkingSlot> findFirstByVehicleTypeAndOccupiedFalse(String vehicleType);
}
