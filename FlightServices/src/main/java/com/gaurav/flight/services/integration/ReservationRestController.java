package com.gaurav.flight.services.integration;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.flight.services.dto.createReservation;
import com.gaurav.flight.services.dto.updateReservationRequest;
import com.gaurav.flight.services.entities.Flight;
import com.gaurav.flight.services.entities.Passenger;
import com.gaurav.flight.services.entities.Reservation;
import com.gaurav.flight.services.repos.FlightRepository;
import com.gaurav.flight.services.repos.PassangerRepository;
import com.gaurav.flight.services.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassangerRepository passengerRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public List<Flight> findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate) {
		return flightRepository.findFlightByDepartureCityAndArrivalCityAndDateOfDeparture(from, to, departureDate);
	}

	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	@Transactional
	public Reservation saveReservation(@RequestBody createReservation request) {
		Flight flight = flightRepository.findById(request.getFlightId()).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		
		
		
		
		
		
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckIn(false);

		return reservationRepository.save(reservation);
	}

	@RequestMapping(value = "/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") int id) {
		return reservationRepository.findById(id).get();
	}

	@RequestMapping(value = "/reservation", method = RequestMethod.PUT)
	public Reservation updateReservation(@RequestBody updateReservationRequest request) {

		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckIn(request.isCheckIn());
		return reservationRepository.save(reservation);
	}
}
