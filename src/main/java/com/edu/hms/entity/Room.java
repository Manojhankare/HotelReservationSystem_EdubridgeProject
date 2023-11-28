package com.edu.hms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rId;

	@Column
	private int RoomNo;

	@Column(name = "RoomType", nullable = false, length = 20)
	private String roomtype;
	@Column(name = "RoomPrice", nullable = false, length = 20)
	private double roomprice;

	@ManyToOne
	@JoinColumn(name = "hId")
	private Hotel hotel;

	@OneToMany(mappedBy = "room")
	private List<Reservations> reservations;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int rId, int roomNo, String roomtype, double roomprice, Hotel hotel, List<Reservations> reservations) {
		super();
		this.rId = rId;
		RoomNo = roomNo;
		this.roomtype = roomtype;
		this.roomprice = roomprice;
		this.hotel = hotel;
		this.reservations = reservations;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public double getRoomprice() {
		return roomprice;
	}

	public void setRoomprice(double roomprice) {
		this.roomprice = roomprice;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}

	public int getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}

	@Override
	public String toString() {
		return "Room [rId=" + rId + ", RoomNo=" + RoomNo + ", roomtype=" + roomtype + ", roomprice=" + roomprice
				+ ", hotel=" + hotel + ", reservations=" + reservations + "]";
	}

}
