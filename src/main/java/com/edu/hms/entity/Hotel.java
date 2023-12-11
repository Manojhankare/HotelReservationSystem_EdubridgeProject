package com.edu.hms.entity;

import java.util.List;
 
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HotelID")
	private int hotelId;

	@Column(name = "HotelName", nullable = false, length = 55)
	@NotBlank(message = "Hotel name should not be blank")
	@Size(max = 55, message = "Hotel name should not exceed 55 characters")
	private String hotelName;

	@Column(name = "Email", nullable = false, length = 55)
	@Email(message = "Invalid email format")
	private String hotelEmail;

	@Column(name = "ContactNumber", nullable = false, unique = true)
	@NotBlank(message = "Contact Number Should not be null!!!")
	@Size(max = 10, message = "Contact number should not exceed 10 characters")
	@Pattern(regexp = "^[0-9]*$", message = "Contact number should only contain digits")
	private String hotelContactNo;

	@Column(name = "Address", nullable = false, length = 90)
	@NotBlank(message = "Hotel address should not be blank")
	@Size(max = 90, message = "Address should not exceed 90 characters")
	private String hotelAddress;

	@Column(name = "City", nullable = false, length = 55)
	@NotBlank(message = "City should not be blank")
	@Size(max = 55, message = "City name should not exceed 55 characters")
	private String hotelCity;

	@Column(length = 255, nullable = false)
	private String hotelDescription;
	
	@Column(length = 255, nullable = false)	 
	private String hotelServices;

	@Column(name = "Status", length = 10, nullable = false)
	private String hotelStatus;

	@Column
	private String hotelImgUrl;// storing url of image of hotel..

//	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "owner_id")
	private HotelOwner hotelOwner;

	@OneToMany(mappedBy = "hotel")
    private List<Room> room;

	public Hotel() {
		super();
	}

	public Hotel(String hotelName, String hotelEmail, String hotelContactNo, String hotelAddress, String hotelCity,
			String hotelServices, String hotelStatus, String hotelDescription, String hotelImgUrl,
			HotelOwner hotelOwner) {
		super();

		this.hotelName = hotelName;
		this.hotelEmail = hotelEmail;
		this.hotelContactNo = hotelContactNo;
		this.hotelAddress = hotelAddress;
		this.hotelCity = hotelCity;
		this.hotelServices = hotelServices;
		this.hotelStatus = hotelStatus;
		this.hotelImgUrl = hotelImgUrl;
		this.hotelOwner = hotelOwner;
		this.hotelDescription = hotelDescription;
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

	public String getHotelStatus() {
		return hotelStatus;
	}

	public void setHotelStatus(String hotelStatus) {
		this.hotelStatus = hotelStatus;
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

	public String getHotelImgUrl() {
		return hotelImgUrl;
	}

	public void setHotelImgUrl(String hotelImgUrl) {
		this.hotelImgUrl = hotelImgUrl;
	}

	public HotelOwner getHotelOwner() {
		return hotelOwner;
	}

	public void setHotelOwner(HotelOwner hotelOwner) {
		this.hotelOwner = hotelOwner;
	}
	public List<Room> getRoom() {
		return room;
	}
	public void setRoom(List<Room> room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelEmail=" + hotelEmail
				+ ", hotelContactNo=" + hotelContactNo + ", hotelAddress=" + hotelAddress + ", hotelCity=" + hotelCity
				+ ", hotelDescription=" + hotelDescription + ", hotelServices=" + hotelServices
				+ ", hotelStatus=" + hotelStatus + ", hotelImgUrl=" + hotelImgUrl + ", hotelOwner=" + hotelOwner
				+ ", room=" + room + "]";
	}

	 
}