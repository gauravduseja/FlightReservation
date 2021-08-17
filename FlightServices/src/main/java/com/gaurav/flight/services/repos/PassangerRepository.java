package com.gaurav.flight.services.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gaurav.flight.services.entities.Flight;
import com.gaurav.flight.services.entities.Passenger;

public interface PassangerRepository extends JpaRepository<Passenger, Integer> {

}
