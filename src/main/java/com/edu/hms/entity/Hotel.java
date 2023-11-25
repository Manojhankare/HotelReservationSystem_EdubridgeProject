package com.edu.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HotelID")
	private int hId;
	@Column(name = "HotelName", nullable = false, length = 55)
	private String hname;
	@Column(name = "Email", nullable = false, length = 55)
	@Email
	private String hemail;
	@Column(name = "ContactNo.", nullable = false, length = 10)
	private int hno;
	@Column(name = "Address", nullable = false, length = 90)
	private String hadd;
	@Column(name = "City", nullable = false, length = 55)
	private String hcity;
	
	@ManyToOne 
	private HotelOwner hotelOwner;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(String hname, String hemail, int hno, String hadd, String hcity, HotelOwner hotelOwner) {
		super();
		this.hname = hname;
		this.hemail = hemail;
		this.hno = hno;
		this.hadd = hadd;
		this.hcity = hcity;
		this.hotelOwner = hotelOwner;
	}

	public int gethId() {
		return hId;
	}

	public void sethId(int hId) {
		this.hId = hId;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHemail() {
		return hemail;
	}

	public void setHemail(String hemail) {
		this.hemail = hemail;
	}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getHadd() {
		return hadd;
	}

	public void setHadd(String hadd) {
		this.hadd = hadd;
	}

	public String getHcity() {
		return hcity;
	}

	public void setHcity(String hcity) {
		this.hcity = hcity;
	}

	public HotelOwner getHotelOwner() {
		return hotelOwner;
	}

	public void setHotelOwner(HotelOwner hotelOwner) {
		this.hotelOwner = hotelOwner;
	}

	@Override
	public String toString() {
		return "Hotel [hId=" + hId + ", hname=" + hname + ", hemail=" + hemail + ", hno=" + hno + ", hadd=" + hadd
				+ ", hcity=" + hcity + ", hotelOwner=" + hotelOwner + "]";
	}
	
}
