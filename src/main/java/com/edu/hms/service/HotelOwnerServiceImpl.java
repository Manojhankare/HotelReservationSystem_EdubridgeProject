package com.edu.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.HotelOwner;
import com.edu.hms.repository.HotelOwnerRepository;

@Service
public class HotelOwnerServiceImpl implements HotelOwnerService {

	@Autowired
	private HotelOwnerRepository hotelOwnerRepository;

	@Override
	public HotelOwner savehotelOwner(HotelOwner hotelOwner) {
		// TODO Auto-generated method stub
		return hotelOwnerRepository.save(hotelOwner);
	}
	

	@Override
	public List<HotelOwner> getAllHotelOwners() {
		return hotelOwnerRepository.findAll();
	}

	@Override
	public HotelOwner getHotelOwnerById(Integer ownerId) {
		return hotelOwnerRepository.findById(ownerId).orElse(null);
	}

	@Override
	public HotelOwner updateHotelOwner(Integer ownerId, HotelOwner updatedHotelOwner) {
		// Check if the hotel owner with the given ID exists
		HotelOwner existingOwner = hotelOwnerRepository.findById(ownerId).orElse(null);
		if (existingOwner != null) {
			// Update the fields that can be modified
			existingOwner.setOwnerName(updatedHotelOwner.getOwnerName());
			existingOwner.setOwnerEmail(updatedHotelOwner.getOwnerEmail());
			existingOwner.setOwnerContactNumber(updatedHotelOwner.getOwnerContactNumber());
			// Save the updated hotel owner
			return hotelOwnerRepository.save(existingOwner);
		}
		return null; // or throw an exception if needed
	}

	@Override
	public void deleteHotelOwner(Integer ownerId) {
		hotelOwnerRepository.deleteById(ownerId);
	}


	

//	@Override
//	public List<HotelOwner> searchHotelOwners(String ownerName, String ownerEmail, String ownerContactNumber) {
//		
//		return hotelOwnerRepository.findByOwnerNameAndOwnerEmailAndOwnerContactNumber(ownerName, ownerEmail, ownerContactNumber);
//	}
	
}
