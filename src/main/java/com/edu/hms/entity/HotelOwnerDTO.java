package com.edu.hms.entity;

import java.util.List;

public class HotelOwnerDTO {

    private int ownerId;
    private String ownerName;
    private String ownerEmail;
    private String ownerContactNumber;
    private String ownerUsername;
    private String ownerPassword;

    private List<HotelDTO> hotels;     
    

    // Constructors, getters, and setters

    public HotelOwnerDTO() {
        // Default constructor
    }

    public HotelOwnerDTO(int ownerId, String ownerName, String ownerEmail, String ownerContactNumber, String ownerUsername,String ownerPassword, List<HotelDTO> hotels ) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerContactNumber = ownerContactNumber;
        this.ownerUsername = ownerUsername;
        this.ownerPassword = ownerPassword;
        this.hotels = hotels;
    }

    // Getters and setters

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerContactNumber() {
        return ownerContactNumber;
    }

    public void setOwnerContactNumber(String ownerContactNumber) {
        this.ownerContactNumber = ownerContactNumber;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }
    
    public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}

	public List<HotelDTO> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelDTO> hotels) {
        this.hotels = hotels;
    }
}
