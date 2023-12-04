package com.edu.hms.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.edu.hms.exceptions.GlobalException;
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

	@OneToMany(mappedBy = "reservation")
    private List<Room> rooms;

	@ManyToOne
	@JoinColumn(name = "hotelID")
	private Hotel hotel; // Foreign key reference to the Hotel entity

	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservations(int reservationID, Date checkInDate, Date checkOutDate, double totalCost, Guest guest,
			List<Room> rooms, Hotel hotel) {
		super();
		this.reservationID = reservationID;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalCost = totalCost;
		this.guest = guest;
		this.rooms = rooms;
		this.hotel = hotel;
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
 

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
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
		return "Reservations [reservationID=" + reservationID + ", checkInDate=" + checkInDate + ", checkOutDate="
				+ checkOutDate + ", totalCost=" + totalCost + ", guest=" + guest + ", rooms=" + rooms + ", hotel="
				+ hotel + "]";
	}

	public void calculateTotalCost() throws GlobalException {
	    if (checkInDate != null && checkOutDate != null && rooms != null && !rooms.isEmpty()) {
	        long durationInMillis = checkOutDate.getTime() - checkInDate.getTime();
	        int durationInDays = (int) (durationInMillis / (1000 * 60 * 60 * 24)); // Convert milliseconds to days

	        double totalCost = 0.0;

	        for (Room room : rooms) {
	            // Room price is per day
	            double roomRatePerDay = room.getRoomPrice();
	            totalCost += roomRatePerDay * durationInDays;
	        }

	        setTotalCost(totalCost);
	    } else {
	        throw new GlobalException("Incomplete data for calculating total cost");
	    }
	}

}
