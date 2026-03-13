package com.parkingsystem.parking.repository;


import com.parkingsystem.parking.model.ParkingFloor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sunny.ansal
 */

@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor,Long> {
}
