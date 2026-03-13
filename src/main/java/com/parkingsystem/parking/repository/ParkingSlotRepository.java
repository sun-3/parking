package com.parkingsystem.parking.repository;

import com.parkingsystem.parking.model.ParkingSlot;
import com.parkingsystem.parking.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *  @author Sunny Ansal
 *  */

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

    Optional<ParkingSlot> findFirstByVehicleTypeAndOccupiedFalse(VehicleType vehicleType);


}

