package com.edu.hms.service;

import java.util.List;

import com.edu.hms.entity.Guest;
import com.edu.hms.exceptions.GlobalException;
 
public interface GuestService {
	
	public Guest saveGuest(Guest guest);

	public List<Guest> getallguest();

	public Guest getGuestById(Integer guestId);

	public Guest updateName(Integer guestId, String newName) throws GlobalException;

	public Guest updateEmail(Integer guestId, String newEmail) throws GlobalException;

	public Guest updatePhone(Integer guestId, String newPhone) throws GlobalException;

	public Guest updateAddress(Integer guestId, String newAddress) throws GlobalException;

	public void deleteGuest(Integer guestId) throws GlobalException	;

	public boolean isEmailUnique(String gemail);

	public boolean isContactNumberUnique(String gno);

	public boolean isUsernameUnique(String gusername);

	public Guest findbyNamePass(String username, String password);

	public Guest loginGuest(String username, String password);
 
}
