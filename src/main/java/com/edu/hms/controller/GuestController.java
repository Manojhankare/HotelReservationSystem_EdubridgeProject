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

import com.edu.hms.entity.Guest;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.service.GuestService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GuestController {

	@Autowired
	private GuestService guestService;

	@PostMapping("/guest/saveGuest")//http://localhost:8990/guest/saveGuest
	public Guest saveGuest(@RequestBody Guest guest){
		
		return guestService.saveGuest(guest);
	}

	@GetMapping("/guest/getallguest")//http://localhost:8990/guest/getallguest
	public List<Guest> getallguest() {
		return guestService.getallguest();
	}
	
	
	@GetMapping("/checkUserExists/{username}/{password}")
	public ResponseEntity<Guest> checkUserExists(@PathVariable("username") String username, @PathVariable("password") String password) {
	    System.out.println("Inside checkuser ");
	    Guest existingGuest = guestService.findbyNamePass(username, password);
	    if (existingGuest != null) {
	        System.out.println("User exists");
	        System.out.println("existingGuest");
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(existingGuest);
	    } else {
	        return ResponseEntity.badRequest().body(null);
	    }
	}
	
	@PostMapping("/loginGuest/{username}/{password}")
	public Guest loginGuest(@PathVariable ("username")String username,@PathVariable("password") String password ) {
		return guestService.loginGuest(username,password);
		
	}

	@GetMapping("/guest/getGuestByid/{guestid}")//http://localhost:8990/getGuestByid/1
	public Guest getGuestById(@PathVariable("guestId") Integer guestId) {
		return guestService.getGuestById(guestId);
	}
	
	@DeleteMapping("/guest/deleteGuest/{guestId}")
	public ResponseEntity<String> deleteGuest(@PathVariable Integer guestId) throws GlobalException {
	    guestService.deleteGuest(guestId);
	    return new ResponseEntity<>("Guest deleted successfully", HttpStatus.OK);
	}

	@PutMapping("/guest/updateName/{guestId}")//http://localhost:8990/guest/updateName/2?newName=manoj
	public ResponseEntity<Guest> updateName(@PathVariable Integer guestId, @RequestParam String newName) throws GlobalException {
		Guest updatedGuest = guestService.updateName(guestId, newName);
		return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
	}

	@PutMapping("/guest/updateEmail/{guestId}")//http://localhost:8990/guest/updateEmail/2?newEmail=manoj2@gmail.com
	public ResponseEntity<Guest> updateEmail(@PathVariable Integer guestId, @RequestParam String newEmail) throws GlobalException{
		Guest updatedGuest = guestService.updateEmail(guestId, newEmail);
		return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
	}

	@PutMapping("/guest/updatePhone/{guestId}")
	public ResponseEntity<Guest> updatePhone(@PathVariable Integer guestId, @RequestParam String newPhone) throws GlobalException {
		Guest updatedGuest = guestService.updatePhone(guestId, newPhone);
		return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
	}
	@PutMapping("/guest/updateAddress/{guestId}")
	public ResponseEntity<Guest> updateAddress(@PathVariable Integer guestId, @RequestParam String newAddress) throws GlobalException{
		Guest updatedGuest = guestService.updateAddress(guestId,newAddress);
		return new ResponseEntity<>(updatedGuest,HttpStatus.OK);
	}
	@GetMapping("/guest/checkUniqueEmail/{gemail}")
    public ResponseEntity<Boolean> checkUniqueEmail(@PathVariable String gemail) {
        boolean isUnique = guestService.isEmailUnique(gemail);
        return new ResponseEntity<>(isUnique, HttpStatus.OK);
    }

    @GetMapping("/guest/checkUniqueContactNumber/{guestcontactno}")
    public ResponseEntity<Boolean> checkUniqueContactNumber(@PathVariable String guestContactNo) {
        boolean isUnique = guestService.isContactNumberUnique(guestContactNo);
        return new ResponseEntity<>(isUnique, HttpStatus.OK);
    }
    @GetMapping("/guest/checkUniqueUsername/{guestusername}")
    public ResponseEntity<Boolean> checkUniqueUsername(@PathVariable String guestUsername) {
        boolean isUnique = guestService.isUsernameUnique(guestUsername);
        return new ResponseEntity<>(isUnique, HttpStatus.OK);
    }
}
