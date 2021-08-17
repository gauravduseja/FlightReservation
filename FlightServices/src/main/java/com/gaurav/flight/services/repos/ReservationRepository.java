package com.gaurav.flight.services.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gaurav.flight.services.entities.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
