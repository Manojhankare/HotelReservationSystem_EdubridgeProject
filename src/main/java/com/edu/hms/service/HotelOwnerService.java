package com.edu.hms.service;

import java.util.List;

//import org.springframework.stereotype.Service;

import com.edu.hms.entity.HotelOwner;

public interface HotelOwnerService {

	HotelOwner savehotelOwner(HotelOwner hotelOwner);

	List<HotelOwner> getAllHotelOwners();

	HotelOwner getHotelOwnerById(Integer ownerId);

	HotelOwner updateHotelOwner(Integer ownerId, HotelOwner updatedHotelOwner);

	void deleteHotelOwner(Integer ownerId);

	List<HotelOwner> searchHotelOwners(String ownerName, String ownerEmail, String contactNumber);

}
