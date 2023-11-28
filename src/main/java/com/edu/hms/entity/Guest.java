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
    private String gname;

    @Column(name = "Age", nullable = false)
    @Min(value = 18, message = "Age should be at least 18")
    @Max(value = 80, message = "Age should not exceed 80")
    private int gage;

    @Column(name = "GuestEmail", nullable = false, unique = true)
    @NotBlank(message = "Email Should not be null!!!")
    @Email(message = "Invalid email format")
    private String gemail;

    @Column(name = "Contact_number", nullable = false, unique = true)
    @NotBlank(message = "Contact Number Should not be null!!!")
    @Size(max = 10, message = "Contact number should not exceed 10 characters")
    @Pattern(regexp = "^[0-9]*$", message = "Contact number should only contain digits")
    private String gno;

    @Column(name = "Address", nullable = false)
    @NotBlank(message = "Address should not be null!!!")
    @Size(max = 255, message = "Address should not exceed 255 characters")
    private String gaddress;

    @Column(name = "Username", nullable = false, unique = true)
    @NotBlank(message = "Username should not be null!!!")
    @Size(max = 10, message = "Username should not exceed 10 characters")
    private String gusername;

    @Column(name = "Pass", nullable = false)
    @NotBlank(message = "Pass should not be null!!!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Invalid password. It must be at least 8 characters long and include at least one letter and one digit.")
    private String gpass;

    @OneToMany(mappedBy = "guest")
    private List<Reservations> reservations;
    
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guest(String gname,int gage, String gemail, String gno, String gaddress, String gusername, String gpass,
			List<Reservations> reservations) {
		super();
		this.gname = gname;
		this.gage = gage;
		this.gemail = gemail;
		this.gno = gno;
		this.gaddress = gaddress;
		this.gusername = gusername;
		this.gpass = gpass;
		this.reservations = reservations;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}
	

	public int getGage() {
		return gage;
	}

	public void setGage(int gage) {
		this.gage = gage;
	}

	public String getGemail() {
		return gemail;
	}

	public void setGemail(String gemail) {
		this.gemail = gemail;
	}

	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}

	public String getGaddress() {
		return gaddress;
	}

	public void setGaddress(String gaddress) {
		this.gaddress = gaddress;
	}

	public String getGusername() {
		return gusername;
	}

	public void setGusername(String gusername) {
		this.gusername = gusername;
	}

	public String getGpass() {
		return gpass;
	}

	public void setGpass(String gpass) {
		this.gpass = gpass;
	}

	public List<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", gname=" + gname + ", gage=" + gage + ", gemail=" + gemail + ", gno="
				+ gno + ", gaddress=" + gaddress + ", gusername=" + gusername + ", gpass=" + gpass + ", reservations="
				+ reservations + "]";
	}
	

}
