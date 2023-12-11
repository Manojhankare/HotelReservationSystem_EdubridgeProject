package com.edu.hms.controller;
 
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.edu.hms.entity.Hotel;
import com.edu.hms.entity.HotelDTO;
import com.edu.hms.exceptions.GlobalException;
 
import com.edu.hms.service.HotelService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HotelController {
 
	@Autowired
	private HotelService hotelService;

//	@PostMapping("/hotels/savehotel")
//	public ResponseEntity<Hotel> saveHotel(@Valid @RequestBody Hotel hotel) throws GlobalException {
//		Hotel savedHotel = hotelService.saveHotel(hotel);
//		//update hotelowner id
//		return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
//	}
	
	@PostMapping("/hotels/savehotel")
	public ResponseEntity<Hotel> saveHotel(@Valid @RequestBody Hotel hotel) throws GlobalException {
	    // Check if hotelServices is a boolean, and if so, convert it to an empty list
	
	    Hotel savedHotel = hotelService.saveHotel(hotel);
	    return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
	}
	

	//

	@GetMapping("/hotels/getAll")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> hotels = hotelService.getAllHotels();
		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}
	
	@GetMapping("/hotels/getHotelsByOwnerId/{ownerId}")
	public ResponseEntity<?> getHotelsByOwnerId(@PathVariable int ownerId) {
	    try {
	        List<Hotel> hotels = hotelService.getHotelsByOwnerId(ownerId);
	        return new ResponseEntity<>(hotels, HttpStatus.OK);
	    } catch (GlobalException e) {
	        return new ResponseEntity<>("Hotels not found for owner with id: " + ownerId, HttpStatus.NOT_FOUND);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	//using DTO
	@GetMapping("/hotels/getAllHotelDTOs")
    public ResponseEntity<List<HotelDTO>> getAllHotelDTOs() {
        List<HotelDTO> hotelDTOs = hotelService.getAllHotelDTOs();
        return new ResponseEntity<>(hotelDTOs, HttpStatus.OK);
    }

    @GetMapping("/hotels/getHotelDTOsByOwner/{ownerId}")
    public ResponseEntity<List<HotelDTO>> getHotelDTOsByOwnerId(@PathVariable int ownerId) {
        try {
            List<HotelDTO> hotelDTOs = hotelService.getHotelDTOsByOwnerId(ownerId);
            return new ResponseEntity<>(hotelDTOs, HttpStatus.OK);
        } catch (GlobalException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
//	@GetMapping("/hotels/getHotelsByOwnerId/{ownerId}")
//	public ResponseEntity<List<Hotel>> getHotelsByOwnerId(@PathVariable int ownerId) {
//	    try {
//	        List<Hotel> hotels = hotelService.getHotelsByOwnerId(ownerId);
//	        return new ResponseEntity<>(hotels, HttpStatus.OK);
//	    } catch (GlobalException e) {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//
//	@GetMapping("/hotels/getHotelsByOwnerId/{ownerId}")
//	public Hotel getHotelsByOwnerId(@PathVariable ("ownerId") int ownerId) throws GlobalException
//	{
//		return hotelService.getHotelsByOwnerId(ownerId);
//	}
	
	  @PutMapping("/hotels/setHotelOwnerToHotel/{hotelId}/{ownerId}")
	    public ResponseEntity<String> setHotelOwnerToHotel(@PathVariable int hotelId, @PathVariable int ownerId) {
	        try {
	            hotelService.setHotelOwnerToHotel(hotelId, ownerId);
	            return ResponseEntity.ok("Hotel owner set successfully.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error setting hotel owner: " + e.getMessage());
	        }
	    }

	@GetMapping("/hotels/getById/{hId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("hId") int hId) throws GlobalException {
		Hotel hotel = hotelService.getHotelById(hId);
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
	
	

	@PutMapping("/hotels/update/{hotelId}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable("hotelId") int hotelId, @Valid @RequestBody Hotel updatedHotel) throws GlobalException {
		Hotel updated = hotelService.updateHotel(hotelId, updatedHotel);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/hotels/delete/{hotelId}")
	public ResponseEntity<Void> deleteHotel(@PathVariable("hotelId") int hotelId) throws GlobalException {
		hotelService.deleteHotel(hotelId);
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
