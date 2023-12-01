package com.edu.hms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 

import com.edu.hms.entity.Hotel;
import com.edu.hms.entity.HotelOwner;
import com.edu.hms.exceptions.HotelNotFoundException;
import com.edu.hms.service.HotelOwnerService;
import com.edu.hms.service.HotelService;

@RestController
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private HotelOwnerService hotelOwnerService;

	
	@PostMapping("/hotel/savehotel")
	public Hotel saveHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
//	@PostMapping("/hotel/savehotel")
//	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel, HttpSession session) {
//	    // Get the currently authenticated hotel owner from the session
//	    HotelOwner hotelOwner = (HotelOwner) session.getAttribute("loggedInHotelOwner");
//
//	    // Set the hotel owner for the hotel
//	    hotel.setHotelOwner(hotelOwner);
//
//	    // Save the hotel
//	    Hotel savedHotel = hotelService.saveHotel(hotel);
//
//	    return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
//	}

	@GetMapping("/hotel/getallhotel")
	public List<Hotel> getallhotel() {
		return hotelService.getallhotel();
	}

	@GetMapping("/hotel/gethotel/{hotelId}")
	public Hotel getHotelById(@PathVariable("hotelId") int hotelId) throws HotelNotFoundException {
		return hotelService.getHotelById(hotelId);
	}

	@PutMapping("/hotel/updatehotel/{hotelId}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable int hotelId, @RequestBody Hotel updatedHotel) {
		Hotel hotel = hotelService.updateHotel(hotelId, updatedHotel);
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}

	@GetMapping("/hotel/search")
	public List<Hotel> searchHotels(@RequestParam(name = "city", required = false) String city,
			@RequestParam(name = "name", required = false) String name) {
		return hotelService.searchHotels(city, name);
	}

}
