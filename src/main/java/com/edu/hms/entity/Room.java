package com.edu.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rId;

	@Column(name = "roomNumber", nullable = false, unique = true)
	private int roomNo;

	@Column(name = "RoomType", nullable = false, length = 20)
	private String roomType;/// mention in frontend i.e. Double, Single, Suite, Bunglow..

	@Column(name = "RoomPrice", nullable = false)
	private double roomPrice;

	@Column(nullable = false)
	private int capacityAdults;

	@Column(nullable = false)
	private int capacityChildren;

	@ManyToOne
	@JoinColumn(name = "hId")
	private Hotel hotel;

	@ManyToOne
	@JoinColumn(name = "reservationID")
	private Reservations reservation;

	public Room() {
		super();
	}

	public Room(int rId, int roomNo, String roomType, double roomPrice, int capacityAdults, int capacityChildren,
			Hotel hotel, Reservations reservation) {
		super();
		this.rId = rId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.capacityAdults = capacityAdults;
		this.capacityChildren = capacityChildren;
		this.hotel = hotel;
		this.reservation = reservation;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getCapacityAdults() {
		return capacityAdults;
	}

	public void setCapacityAdults(int capacityAdults) {
		this.capacityAdults = capacityAdults;
	}

	public int getCapacityChildren() {
		return capacityChildren;
	}

	public void setCapacityChildren(int capacityChildren) {
		this.capacityChildren = capacityChildren;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Reservations getReservation() {
		return reservation;
	}

	public void setReservation(Reservations reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Room [rId=" + rId + ", roomNo=" + roomNo + ", roomType=" + roomType + ", roomPrice=" + roomPrice
				+ ", capacityAdults=" + capacityAdults + ", capacityChildren=" + capacityChildren + ", hotel=" + hotel
				+ ", reservation=" + reservation + "]";
	}

}