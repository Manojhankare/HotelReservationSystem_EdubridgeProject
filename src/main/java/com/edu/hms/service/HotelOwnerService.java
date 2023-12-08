package com.edu.hms.service;

import java.util.List;
import com.edu.hms.entity.HotelOwner;

public interface HotelOwnerService {

    HotelOwner saveHotelOwner(HotelOwner hotelOwner);

    List<HotelOwner> getAllHotelOwners();

    HotelOwner getHotelOwnerById(Integer ownerId);

    HotelOwner updateHotelOwner(Integer ownerId, HotelOwner updatedHotelOwner);

    void deleteHotelOwner(Integer ownerId);

    List<HotelOwner> searchHotelOwners(String ownerName, String ownerEmail, String contactNumber);

	boolean isEmailUnique(String email);

	boolean isContactNumberUnique(String contactNumber);

	boolean isUsernameUnique(String username);

	HotelOwner loginhotelOwner(String username, String password);
}

