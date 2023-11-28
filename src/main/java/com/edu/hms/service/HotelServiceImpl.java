package com.edu.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.Hotel;
import com.edu.hms.exceptions.HotelNotFoundException;
import com.edu.hms.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		if(findByemail)
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getallhotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(int hotelId) throws HotelNotFoundException {
		return hotelRepository.findById(hotelId)
				.orElseThrow(() -> new HotelNotFoundException("Hotel not found with ID: " + hotelId));
	}

	@Override
	public Hotel updateHotel(int hotelId, Hotel updatedHotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> searchHotels(String city, String name) {
		if (city != null && name != null) {
			// If both city and name are provided, search by both
			return hotelRepository.findByHcityAndHname(city, name);
		} else if (city != null) {
			// If only city is provided, search by city
			return hotelRepository.findByHcity(city);
		} else if (name != null) {
			// If only name is provided, search by name
			return hotelRepository.findByHname(name);
		} else {
			// If neither city nor name is provided, return all hotels
			return hotelRepository.findAll();
		}
	}

}
