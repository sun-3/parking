package com.parkingsystem.parking.repository;


import com.parkingsystem.parking.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  @author Sunny Ansal
 *  */

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
