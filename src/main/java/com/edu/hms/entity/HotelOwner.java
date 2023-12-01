package com.edu.hms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class HotelOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ownerId;

	@Column(name = "OwnerName", nullable = false)
	@NotBlank(message = "Owner name should not be blank")
	@Size(max = 255, message = "Owner name should not exceed 255 characters")
	private String ownerName;

	@Column(name = "OwnerEmail", nullable = false, unique = true)
	@NotBlank(message = "Owner email should not be blank")
	@Email(message = "Invalid email format")
	@Size(max = 255, message = "Owner email should not exceed 255 characters")
	private String ownerEmail;

	@Column(name = "ContactNumber", nullable = false)
	@NotBlank(message = "Contact number should not be blank")
	@Size(max = 15, message = "Contact number should not exceed 15 characters")
	@Pattern(regexp = "^[0-9]*$", message = "Contact number should only contain digits")
	private String contactNumber;

	@Column(name = "Username", nullable = false, unique = true)
	@NotBlank(message = "Username should not be blank")
	@Size(max = 50, message = "Username should not exceed 50 characters")
	private String hoUsername;

	@Column(name = "Password", nullable = false)
	@NotBlank(message = "Password should not be blank")
	//@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Invalid password. It must be at least 8 characters long and include at least one letter and one digit.")
	private String password;

	@OneToMany(mappedBy = "hotelOwner")
	private List<Hotel> hotel; // One hotel owner can have multiple hotels

	public HotelOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelOwner(Long ownerId,
			@NotBlank(message = "Owner name should not be blank") @Size(max = 255, message = "Owner name should not exceed 255 characters") String ownerName,
			@NotBlank(message = "Owner email should not be blank") @Email(message = "Invalid email format") @Size(max = 255, message = "Owner email should not exceed 255 characters") String ownerEmail,
			@NotBlank(message = "Contact number should not be blank") @Size(max = 15, message = "Contact number should not exceed 15 characters") @Pattern(regexp = "^[0-9]*$", message = "Contact number should only contain digits") String contactNumber,
			@NotBlank(message = "Username should not be blank") @Size(max = 50, message = "Username should not exceed 50 characters") String hoUsername,
			@NotBlank(message = "Password should not be blank") @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Invalid password. It must be at least 8 characters long and include at least one letter and one digit.") String password,
			List<Hotel> hotel) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.contactNumber = contactNumber;
		this.hoUsername = hoUsername;
		this.password = password;
		this.hotel = hotel;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getHoUsername() {
		return hoUsername;
	}

	public void setHoUsername(String hoUsername) {
		this.hoUsername = hoUsername;
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
				+ ", contactNumber=" + contactNumber + ", hoUsername=" + hoUsername + ", password=" + password
				+ ", hotel=" + hotel + "]";
	}

}
