package com.edu.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.Guest;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepository guestRepository;

	@Override
	public Guest saveGuest(Guest guest)  {
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
	public Guest updateName(Integer guestId, String newName) throws GlobalException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			Guest guest = guestOptional.get();
			guest.setGuestName(newName);
			return guestRepository.save(guest);
		} else {
			throw new GlobalException("Guest with ID " + guestId + " not found.");
		}
	}

	@Override
	public Guest updateEmail(Integer guestId, String newEmail) throws GlobalException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			Guest guest = guestOptional.get();
			guest.setGuestEmail(newEmail);
			return guestRepository.save(guest);
		} else {
			throw new GlobalException("Guest with ID " + guestId + " not found.");
		}
	}

	@Override
	public Guest updatePhone(Integer guestId, String newPhone) throws GlobalException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			Guest guest = guestOptional.get();
			guest.setGuestContactNo(newPhone);
			return guestRepository.save(guest);
		} else {
			throw new GlobalException("Guest with ID " + guestId + " not found.");
		}
	}

	@Override
	public Guest updateAddress(Integer guestId, String newAddress) throws GlobalException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			Guest guest = guestOptional.get();
			guest.setGuestAddress(newAddress);
			return guestRepository.save(guest);
		} else {
			throw new GlobalException("Guest with ID " + guestId + " not found.");
		}
	}

	@Override
	public void deleteGuest(Integer guestId) throws GlobalException {
		Optional<Guest> guestOptional = guestRepository.findById(guestId);
		if (guestOptional.isPresent()) {
			guestRepository.deleteById(guestId);
		} else {
			throw new GlobalException("Guest with ID " + guestId + " not found.");
		}
	}


    @Override
    public boolean isEmailUnique(String gemail) {
        return !guestRepository.existsByGuestEmail(gemail);
    }

    @Override
    public boolean isContactNumberUnique(String gno) {
        return !guestRepository.existsByGuestContactNo(gno);
    }

    @Override
    public boolean isUsernameUnique(String gusername) {
        return !guestRepository.existsByGuestUsername(gusername);
    }

	@Override
	public Guest findbyNamePass(String username, String password) {
		// TODO Auto-generated method stub
		
	        return guestRepository.findByGuestUsernameAndGuestPass(username, password);
	     
	}

	@Override
	public Guest loginGuest(String username, String password) {
		// TODO Auto-generated method stub
		
		Guest guest=guestRepository.findByGuestByUsername(username);
		if (guest!=null && password.equals(guest.getGuestPass())) {
			
			return guest;
		}
		else {
			return null;
		}
	}
}
