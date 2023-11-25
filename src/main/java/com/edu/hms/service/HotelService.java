package com.edu.hms.service;
 
import java.util.List;

import com.edu.hms.entity.Hotel;
 
public interface HotelService {

	Hotel saveHotel(Hotel hotel);

	List<Hotel> getallhotel();


}
