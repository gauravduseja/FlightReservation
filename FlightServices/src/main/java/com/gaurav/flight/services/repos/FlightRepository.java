package com.gaurav.flight.services.repos;

import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gaurav.flight.services.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	//@Query("from flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlightByDepartureCityAndArrivalCityAndDateOfDeparture(@Param("departureCity") String from,@Param("arrivalCity") String to,@Param("dateOfDeparture") Date departureDate);
		
	

}
