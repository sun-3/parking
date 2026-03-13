package com.parkingsystem.parking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sunny.ansal
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingFloor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int floor;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<ParkingSlot> slots;

}
