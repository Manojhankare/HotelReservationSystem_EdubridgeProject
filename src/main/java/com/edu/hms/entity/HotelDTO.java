package com.edu.hms.entity;

import java.util.List;

public class HotelDTO {

	private int hotelId;
	private String hotelName;
	private String hotelEmail;
	private String hotelContactNo;
	private String hotelAddress;
	private String hotelCity;
	private String hotelDescription;
	private String hotelServices;
	private String hotelStatus;
	private String hotelImgUrl;
	

	private HotelOwnerDTO hotelOwner;
	private List<RoomDTO> rooms;
	
		
	public HotelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelDTO(int hotelId, String hotelName, String hotelEmail, String hotelContactNo, String hotelAddress,
			String hotelCity, String hotelDescription, String hotelServices, String hotelStatus, String hotelImgUrl,
			HotelOwnerDTO hotelOwner, List<RoomDTO> rooms) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelEmail = hotelEmail;
		this.hotelContactNo = hotelContactNo;
		this.hotelAddress = hotelAddress;
		this.hotelCity = hotelCity;
		this.hotelDescription = hotelDescription;
		this.hotelServices = hotelServices;
		this.hotelStatus = hotelStatus;
		this.hotelImgUrl = hotelImgUrl;
		this.hotelOwner = hotelOwner;
		this.rooms = rooms;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public String getHotelContactNo() {
		return hotelContactNo;
	}

	public void setHotelContactNo(String hotelContactNo) {
		this.hotelContactNo = hotelContactNo;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getHotelServices() {
		return hotelServices;
	}

	public void setHotelServices(String hotelServices) {
		this.hotelServices = hotelServices;
	}

	public String getHotelStatus() {
		return hotelStatus;
	}

	public void setHotelStatus(String hotelStatus) {
		this.hotelStatus = hotelStatus;
	}

	public String getHotelImgUrl() {
		return hotelImgUrl;
	}

	public void setHotelImgUrl(String hotelImgUrl) {
		this.hotelImgUrl = hotelImgUrl;
	}

	public HotelOwnerDTO getHotelOwner() {
		return hotelOwner;
	}

	public void setHotelOwner(HotelOwnerDTO hotelOwner) {
		this.hotelOwner = hotelOwner;
	}

	public List<RoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDTO> rooms) {
		this.rooms = rooms;
	}
		

}