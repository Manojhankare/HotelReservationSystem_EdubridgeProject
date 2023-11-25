package com.edu.hms.service;

import java.util.List;

import com.edu.hms.entity.Guest;
import com.edu.hms.exceptions.GuestNotFoundException;

public interface GuestService {
	
	public Guest saveGuest(Guest guest);

	public List<Guest> getallguest();

	public Guest getGuestById(Integer guestId);

	public Guest updateName(Integer guestId, String newName) throws GuestNotFoundException;

	public Guest updateEmail(Integer guestId, String newEmail) throws GuestNotFoundException;

	public Guest updatePhone(Integer guestId, String newPhone) throws GuestNotFoundException;

	public Guest updateAddress(Integer guestId, String newAddress) throws GuestNotFoundException;
 
}
