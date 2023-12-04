package com.edu.hms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.hms.entity.Hotel;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.service.HotelService;

@RestController
public class HotelController {
 
	@Autowired
	private HotelService hotelService;

	@PostMapping("/hotels/savehotel")
	public ResponseEntity<Hotel> saveHotel(@Valid @RequestBody Hotel hotel) {
		Hotel savedHotel = hotelService.saveHotel(hotel);
		return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
	}

	@GetMapping("/hotels/getAll")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> hotels = hotelService.getAllHotels();
		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}

	@GetMapping("/hotels/getById/{hId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("hId") int hId) throws GlobalException {
		Hotel hotel = hotelService.getHotelById(hId);
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}

	@PutMapping("/hotels/update/{hId}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable("hId") int hId, @Valid @RequestBody Hotel updatedHotel) throws GlobalException {
		Hotel updated = hotelService.updateHotel(hId, updatedHotel);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/hotels/delete/{hId}")
	public ResponseEntity<Void> deleteHotel(@PathVariable("hId") int hId) throws GlobalException {
		hotelService.deleteHotel(hId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/hotels/searchByName/{name}")
	public ResponseEntity<List<Hotel>> searchByName(@PathVariable("name") String name) {
		List<Hotel> hotels = hotelService.searchByName(name);
		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}

	@GetMapping("/hotels/searchByCity/{city}")
	public ResponseEntity<List<Hotel>> searchByCity(@PathVariable("city") String city) {
		List<Hotel> hotels = hotelService.searchByCity(city);
		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}

	@GetMapping("/hotels/searchByOwner/{ownerId}")
	public ResponseEntity<List<Hotel>> searchByOwner(@PathVariable("ownerId") int ownerId) {
		List<Hotel> hotels = hotelService.searchByOwner(ownerId);
		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}


}
