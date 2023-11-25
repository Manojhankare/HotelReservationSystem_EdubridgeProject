package com.edu.hms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationID;

    @NotNull(message = "Check-in date should not be null")
    @Future(message = "Check-in date should be in the future")
    private Date checkInDate;

    @NotNull(message = "Check-out date should not be null")
    @Future(message = "Check-out date should be in the future")
    private Date checkOutDate;

    private double totalCost;

    @ManyToOne
    @JoinColumn(name = "guestID")
    private Guest guest; // Foreign key reference to the Guest entity

    @ManyToOne
    @JoinColumn(name = "roomID")
    private Room room; // Foreign key reference to the Room entity

    @ManyToOne
    @JoinColumn(name = "hotelID")
    private Hotel hotel; // Foreign key reference to the Hotel entity

    
	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Reservations(Guest guest, Room room, Hotel hotel, Date checkInDate, Date checkOutDate, double totalCost) {
		super();
		this.guest = guest;
		this.room = room;
		this.hotel = hotel;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalCost = totalCost;
	}


	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	@Override
	public String toString() {
		return "Reservations [reservationID=" + reservationID + ", guest=" + guest + ", room=" + room + ", hotel="
				+ hotel + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", totalCost=" + totalCost
				+ "]";
	}
	
	 

}
