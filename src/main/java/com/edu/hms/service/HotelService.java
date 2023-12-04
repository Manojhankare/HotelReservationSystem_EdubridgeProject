package com.edu.hms.service;
 
import java.util.List;

import javax.validation.Valid;

import com.edu.hms.entity.Hotel;
import com.edu.hms.exceptions.GlobalException;
 
 
public interface HotelService {

	Hotel saveHotel(@Valid Hotel hotel);

	List<Hotel> getAllHotels();

	Hotel getHotelById(int hId) throws GlobalException;

	Hotel updateHotel(int hId, @Valid Hotel updatedHotel) throws GlobalException;

	void deleteHotel(int hId) throws GlobalException;

	List<Hotel> searchByName(String name);

	List<Hotel> searchByCity(String city);

	List<Hotel> searchByOwner(int ownerId);

	List<Hotel> searchByContactNo(int hno);

 
}
