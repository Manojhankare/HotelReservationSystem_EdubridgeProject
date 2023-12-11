package com.edu.hms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class HotelOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;

	@Column(name = "OwnerName", nullable = false)
	@NotBlank(message = "Owner name should not be blank")
	@Size(max = 255, message = "Owner name should not exceed 255 characters")
	private String ownerName;

	@Column(name = "OwnerEmail", nullable = false, unique = true)
	@NotBlank(message = "Owner email should not be blank")
	@Email(message = "Invalid email format")
	@Size(max = 255, message = "Owner email should not exceed 255 characters")
	private String ownerEmail;

	@Column(name = "OwnerContactNumber", nullable = false)
	@NotBlank(message = "Contact number should not be blank")
	@Size(max = 10, message = "Contact number should not exceed 10 characters")
	@Pattern(regexp = "^[0-9]*$", message = "Contact number should only contain digits")
	private String ownerContactNumber;

	@Column(name = "ownerUsername", nullable = false, unique = true)
	@NotBlank(message = "Username should not be blank")
	@Size(max = 50, message = "Username should not exceed 50 characters")
	private String ownerUsername;

	@Column(name = "ownerPassword", nullable = false)
	@NotBlank(message = "Password should not be blank")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Invalid password. It must meet the following criteria:\n"
			+ "- At least 8 characters long\n" + "- At least one uppercase letter\n" + "- At least one digit\n"
			+ "- At least one symbol (@$!%*?&)")
	private String password;
	

//	@JsonIgnore
//	@OneToMany(mappedBy = "hotelOwner")
////    @JsonManagedReference	
	@OneToMany(mappedBy = "hotelOwner", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Hotel> hotel; // One hotel owner can have multiple hotels

	public HotelOwner() {
		super();
	}

	public HotelOwner(int ownerId, String ownerName, String ownerEmail, String ownerContactNumber, String ownerUsername,
			String password, List<Hotel> hotel) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.ownerContactNumber = ownerContactNumber;
		this.ownerUsername = ownerUsername;
		this.password = password;
		this.hotel = hotel;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "HotelOwner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerEmail=" + ownerEmail
				+ ", ownerContactNumber=" + ownerContactNumber + ", ownerUsername=" + ownerUsername + ", password="
				+ password + ", hotel=" + hotel + "]";
	}

}
