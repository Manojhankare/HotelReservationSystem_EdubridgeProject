package com.edu.hms.service;
 
import java.util.List;

import com.edu.hms.entity.Hotel;
import com.edu.hms.exceptions.HotelNotFoundException;
 
public interface HotelService {

	Hotel saveHotel(Hotel hotel);

	List<Hotel> getallhotel();

	Hotel getHotelById(int hotelId) throws HotelNotFoundException;

	Hotel updateHotel(int hotelId, Hotel updatedHotel);

	List<Hotel> searchHotels(String city, String name);


}
