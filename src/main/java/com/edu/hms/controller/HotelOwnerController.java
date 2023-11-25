package com.edu.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.edu.hms.entity.HotelOwner;
import com.edu.hms.service.HotelOwnerService;

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

	@GetMapping("/hotelOwner/getHotelOwnerById/{hoid}")
	public HotelOwner getHotelOwnerById(@PathVariable("hoid") Integer ownerId) {
		return hotelOwnerService.getHotelOwnerById(ownerId);
	}
	
}
