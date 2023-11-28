package com.edu.hms.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.edu.hms.entity.HotelOwner;
import com.edu.hms.service.HotelOwnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HotelOwnerController {

	@Autowired
	private HotelOwnerService hotelOwnerService;

	@PostMapping("/hotelOwner/saveHotelOwner")
	public HotelOwner saveHotelOwner(@RequestBody HotelOwner hotelOwner) {
		return hotelOwnerService.savehotelOwner(hotelOwner);
	}

	@GetMapping("/hotelOwner/getAll")
	public List<HotelOwner> getAllHotelOwners() {
		return hotelOwnerService.getAllHotelOwners();
	}

//	@GetMapping("/hotelOwner/getHotelOwnerById/{hoid}")
//	public HotelOwner getHotelOwnerById(@PathVariable("hoid") Integer ownerId) {
//		return hotelOwnerService.getHotelOwnerById(ownerId);
//	}
	
  
//    @PostMapping("/hotelowner/save")
//    public ResponseEntity<HotelOwner> saveHotelOwner(@RequestBody HotelOwner hotelOwner) {
//        HotelOwner savedHotelOwner = hotelOwnerService.saveHotelOwner(hotelOwner);
//        return new ResponseEntity<>(savedHotelOwner, HttpStatus.CREATED);
//    }
   
	    @GetMapping("/hotelOwner/getHotelOwnerById/{ownerId}")
	    public ResponseEntity<HotelOwner> getHotelOwnerById(@PathVariable("ownerId") Integer ownerId) {
	        HotelOwner hotelOwner = hotelOwnerService.getHotelOwnerById(ownerId);
	        return new ResponseEntity<>(hotelOwner, HttpStatus.OK);
	    }
 

	    //  Update
	    @PutMapping("/hotelOwner/updateHotelOwner/{ownerId}")
	    public ResponseEntity<HotelOwner> updateHotelOwner(@PathVariable("ownerId") Integer ownerId,
	                                                       @RequestBody HotelOwner updatedHotelOwner) {
	        HotelOwner hotelOwner = hotelOwnerService.updateHotelOwner(ownerId, updatedHotelOwner);
	        return new ResponseEntity<>(hotelOwner, HttpStatus.OK);
	    }

	    //  Delete
	    @DeleteMapping("/hotelOwner/deleteHotelOwner/{ownerId}")
	    public ResponseEntity<Void> deleteHotelOwner(@PathVariable("ownerId") Integer ownerId) {
	        hotelOwnerService.deleteHotelOwner(ownerId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    // Search
	    @GetMapping("/searchHotelOwners")
	    public List<HotelOwner> searchHotelOwners(@RequestParam(name = "ownerName", required = false) String ownerName,
	                                              @RequestParam(name = "ownerEmail", required = false) String ownerEmail,
	                                              @RequestParam(name = "contactNumber", required = false) String contactNumber) {
	        return hotelOwnerService.searchHotelOwners(ownerName, ownerEmail, contactNumber);
	    }
	

}