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
	private int roomId;

	@Column(name = "roomNumber", nullable = false, unique = true)
	private int roomNo;

	@Column(name = "RoomType", nullable = false, length = 20)
	private String roomType;/// mention in frontend i.e. Double, Single, Suite, Bunglow..

	@Column(name = "RoomPrice", nullable = false)
	private double roomPrice;

	@Column(nullable = false)
	private int roomcapacityAdults;

	@Column(nullable = false)
	private int roomcapacityChildren;

	@ManyToOne
	@JoinColumn(name = "hotelId")
	private Hotel hotel;

	@ManyToOne
	@JoinColumn(name = "reservationID")
	private Reservations reservation;

	public Room() {
		super();
	}

	 
	public Room(int roomId, int roomNo, String roomType, double roomPrice, int roomcapacityAdults,
			int roomcapacityChildren, Hotel hotel, Reservations reservation) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomcapacityAdults = roomcapacityAdults;
		this.roomcapacityChildren = roomcapacityChildren;
		this.hotel = hotel;
		this.reservation = reservation;
	}
	


	public int getRoomId() {
		return roomId;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public int getRoomcapacityAdults() {
		return roomcapacityAdults;
	}


	public void setRoomcapacityAdults(int roomcapacityAdults) {
		this.roomcapacityAdults = roomcapacityAdults;
	}


	public int getRoomcapacityChildren() {
		return roomcapacityChildren;
	}


	public void setRoomcapacityChildren(int roomcapacityChildren) {
		this.roomcapacityChildren = roomcapacityChildren;
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
		return "Room [roomId=" + roomId + ", roomNo=" + roomNo + ", roomType=" + roomType + ", roomPrice=" + roomPrice
				+ ", roomcapacityAdults=" + roomcapacityAdults + ", roomcapacityChildren=" + roomcapacityChildren
				+ ", hotel=" + hotel + ", reservation=" + reservation + "]";
	}

}