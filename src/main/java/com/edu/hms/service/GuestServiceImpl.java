package com.edu.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.Guest;
import com.edu.hms.exceptions.GuestNotFoundException;
import com.edu.hms.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepository guestRepository;

	@Override
	public Guest saveGuest(Guest guest) {
		// TODO Auto-generated method stub
		return guestRepository.save(guest);
	}

	@Override
	public List<Guest> getallguest() {
		// TODO Auto-generated method stub
		return guestRepository.findAll();
	}

	@Override
	public Guest getGuestById(Integer guestId) {
		// TODO Auto-generated method stub
		return guestRepository.findById(guestId).get();
	}

	@Override
	public Guest updateName(Integer guestId, String newName) throws GuestNotFoundException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			Guest guest = guestOptional.get();
			guest.setGname(newName);
			return guestRepository.save(guest);
		} else {
			throw new GuestNotFoundException("Guest with ID " + guestId + " not found.");
		}
	}

	@Override
	public Guest updateEmail(Integer guestId, String newEmail) throws GuestNotFoundException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			Guest guest = guestOptional.get();
			guest.setGemail(newEmail);
			return guestRepository.save(guest);
		} else {
			throw new GuestNotFoundException("Guest with ID " + guestId + " not found.");
		}
	}

	@Override
	public Guest updatePhone(Integer guestId, String newPhone) throws GuestNotFoundException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			Guest guest = guestOptional.get();
			guest.setGno(newPhone);
			return guestRepository.save(guest);
		} else {
			throw new GuestNotFoundException("Guest with ID " + guestId + " not found.");
		}
	}

	@Override
	public Guest updateAddress(Integer guestId, String newAddress) throws GuestNotFoundException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			Guest guest = guestOptional.get();
			guest.setGaddress(newAddress);
			return guestRepository.save(guest);
		} else {
			throw new GuestNotFoundException("Guest with ID " + guestId + " not found.");
		}
	}

	@Override
	public void deleteGuest(Integer guestId) throws GuestNotFoundException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			guestRepository.deleteById(guestId);
		} else {
			throw new GuestNotFoundException("Guest with ID " + guestId + " not found.");
		}
	}
}
