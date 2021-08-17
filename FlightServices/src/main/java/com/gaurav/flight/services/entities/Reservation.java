package com.gaurav.flight.services.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation extends AbstractEntity{
	
	
	private boolean isCheckIn;
	private int numberOfBags;
	@OneToOne
	private Flight flight;
	@OneToOne
	private Passenger passenger;
	
	public boolean isCheckIn() {
		return isCheckIn;
	}
	public void setCheckIn(boolean isCheckIn) {
		this.isCheckIn = isCheckIn;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	
	
	
	

}
