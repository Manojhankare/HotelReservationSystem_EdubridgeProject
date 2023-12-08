package com.edu.hms.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guestId;

	@Column(name = "GuestName", nullable = false, length = 25)
	@NotBlank(message = "Name should not be null!!!")
	private String guestName;

	@Column(name = "Age", nullable = false)
	@Min(value = 18, message = "Age should be at least 18")
	@Max(value = 80, message = "Age should not exceed 80")
	private int guestAge;

	@Column(name = "GuestEmail", nullable = false, unique = true)
	@NotBlank(message = "Email Should not be null!!!")
	@Email(message = "Invalid email format")
	private String guestEmail;

	@Column(name = "ContactNumber", nullable = false, unique = true)
	@NotBlank(message = "Contact Number Should not be null!!!")
	@Size(max = 10, message = "Contact number should not exceed 10 characters")
	@Pattern(regexp = "^[0-9]*$", message = "Contact number should only contain digits")
	private String guestContactNo;

	@Column(name = "Address", nullable = false)
	@NotBlank(message = "Address should not be null!!!")
	@Size(max = 255, message = "Address should not exceed 255 characters")
	private String guestAddress;

	@Column(name = "Username", nullable = false, unique = true)
	@NotBlank(message = "Username should not be null!!!")
	@Size(max = 10, message = "Username should not exceed 10 characters")
	private String guestUsername;

	// password validations
	@Column(name = "Pass", nullable = false)
	@NotBlank(message = "Password should not be null or empty.")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Invalid password. It must meet the following criteria:\n"
			+ "- At least 8 characters long\n" + "- At least one uppercase letter\n" + "- At least one digit\n"
			+ "- At least one symbol (@$!%*?&)")
	private String guestPass;

	@OneToMany(mappedBy = "guest")
	private List<Reservations> reservations;

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guest(String guestName, int guestAge, String guestEmail, String guestContactNo, String guestAddress,
			String guestUsername, String guestPass, List<Reservations> reservations) {
		super();

		this.guestName = guestName;
		this.guestAge = guestAge;
		this.guestEmail = guestEmail;
		this.guestContactNo = guestContactNo;
		this.guestAddress = guestAddress;
		this.guestUsername = guestUsername;
		this.guestPass = guestPass;
		this.reservations = reservations;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public int getGuestAge() {
		return guestAge;
	}

	public void setGuestAge(int guestAge) {
		this.guestAge = guestAge;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public String getGuestContactNo() {
		return guestContactNo;
	}

	public void setGuestContactNo(String guestContactNo) {
		this.guestContactNo = guestContactNo;
	}

	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	public String getGuestUsername() {
		return guestUsername;
	}

	public void setGuestUsername(String guestUsername) {
		this.guestUsername = guestUsername;
	}

	public String getGuestPass() {
		return guestPass;
	}

	public void setGuestPass(String guestPass) {
		this.guestPass = guestPass;
	}

	public List<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", guestName=" + guestName + ", guestAge=" + guestAge + ", guestEmail="
				+ guestEmail + ", guestContactNo=" + guestContactNo + ", guestAddress=" + guestAddress
				+ ", guestUsername=" + guestUsername + ", guestPass=" + guestPass + ", reservations=" + reservations
				+ "]";
	}

}
