package com.edu.hms.controller;

import java.util.List;

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

import com.edu.hms.entity.Guest;
import com.edu.hms.exceptions.GuestNotFoundException;
import com.edu.hms.service.GuestService;

@RestController
public class GuestController {

	@Autowired
	private GuestService guestService;

	@PostMapping("/saveGuest")//https
	public Guest saveGuest(@RequestBody Guest guest) {
		return guestService.saveGuest(guest);
	}

	@GetMapping("/getallguest")
	public List<Guest> getallguest() {
		return guestService.getallguest();
	}

	@GetMapping("/getGuestByid/{gid}")
	public Guest getGuestById(@PathVariable("gid") Integer guestId) {
		return guestService.getGuestById(guestId);
	}
	
	@GetMapping("/guestbyid")

	@PutMapping("/guest/updateName/{guestId}")
	public ResponseEntity<Guest> updateName(@PathVariable Integer guestId, @RequestParam String newName) throws GuestNotFoundException {
		Guest updatedGuest = guestService.updateName(guestId, newName);
		return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
	}

	@PutMapping("/guest/updateEmail/{guestId}")
	public ResponseEntity<Guest> updateEmail(@PathVariable Integer guestId, @RequestParam String newEmail) throws GuestNotFoundException {
		Guest updatedGuest = guestService.updateEmail(guestId, newEmail);
		return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
	}

	@PutMapping("/guest/updatePhone/{guestId}")
	public ResponseEntity<Guest> updatePhone(@PathVariable Integer guestId, @RequestParam String newPhone) throws GuestNotFoundException {
		Guest updatedGuest = guestService.updatePhone(guestId, newPhone);
		return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
	}
	@PutMapping("/guest/updateAddress/{guestId}")
	public ResponseEntity<Guest> updateAddress(@PathVariable Integer guestId, @RequestParam String newAddress) throws GuestNotFoundException{
		Guest updatedGuest = guestService.updateAddress(guestId,newAddress);
		return new ResponseEntity<>(updatedGuest,HttpStatus.OK);
	}
}
