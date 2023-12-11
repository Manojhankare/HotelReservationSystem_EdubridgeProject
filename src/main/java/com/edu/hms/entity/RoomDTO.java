package com.edu.hms.entity;

 
public class RoomDTO {

    private int roomId;
    private int roomNo;
    private String roomType;
    private double roomPrice;
    private int roomCapacityAdults;
    private int roomCapacityChildren;
    
    private HotelDTO hotel; // Include HotelDTO

    private ReservationsDTO reservation; // Include ReservationDTO


    // Constructors, getters, and setters

    public RoomDTO() {
        // Default constructor
    }

    public RoomDTO(int roomId, int roomNo, String roomType, double roomPrice, int roomCapacityAdults, int roomCapacityChildren,HotelDTO hotel, ReservationsDTO reservation) {
        this.roomId = roomId;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomCapacityAdults = roomCapacityAdults;
        this.roomCapacityChildren = roomCapacityChildren;
        this.hotel = hotel;
        this.reservation = reservation;
    }

    // Getters and setters

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public int getRoomCapacityAdults() {
        return roomCapacityAdults;
    }

    public void setRoomCapacityAdults(int roomCapacityAdults) {
        this.roomCapacityAdults = roomCapacityAdults;
    }

    public int getRoomCapacityChildren() {
        return roomCapacityChildren;
    }

    public void setRoomCapacityChildren(int roomCapacityChildren) {
        this.roomCapacityChildren = roomCapacityChildren;
    }
    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public ReservationsDTO getReservation() {
        return reservation;
    }

    public void setReservation(ReservationsDTO reservation) {
        this.reservation = reservation;
    }
}
