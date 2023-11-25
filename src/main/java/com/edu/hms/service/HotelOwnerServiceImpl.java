package com.edu.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.HotelOwner;
import com.edu.hms.repository.HotelOwnerRepository;


@Service
public class HotelOwnerServiceImpl implements HotelOwnerService{
	
	@Autowired
	private HotelOwnerRepository hotelOwnerRepository;

	@Override
	public HotelOwner savehotelOwner(HotelOwner hotelOwner) {
		
		return hotelOwnerRepository.save(hotelOwner);
	}

	@Override
	public List<HotelOwner> getAllHotelOwners() { 
		return hotelOwnerRepository.findAll();
	}

	@Override
	public HotelOwner getHotelOwnerById(Integer ownerId) {
		// TODO Auto-generated method stub
		return hotelOwnerRepository.findById(ownerId).get();
	} 
	
}
