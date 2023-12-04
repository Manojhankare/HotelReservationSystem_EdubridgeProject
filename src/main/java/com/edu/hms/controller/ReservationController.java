package com.edu.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.hms.entity.Reservations;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired ReservationService reservationService;

	 @GetMapping
	    public ResponseEntity<List<Reservations>> getAllReservations() {
	        List<Reservations> reservations = reservationService.getAllReservations();
	        return new ResponseEntity<>(reservations, HttpStatus.OK);
	    }

	    // get a reservation by ID
	    @GetMapping("/reservation/{reservationId}")
	    public ResponseEntity<Reservations> getReservationById(@PathVariable int reservationId) throws GlobalException {
	        Reservations reservation = reservationService.getReservationById(reservationId);
	        if (reservation != null) {
	            return new ResponseEntity<>(reservation, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    //  create a new reservation
	    @PostMapping("/reservation/create")
	    public ResponseEntity<Reservations> createReservation(@Validated @RequestBody Reservations reservation) throws GlobalException {
	        // Validation is handled by @Validated annotation
	        Reservations createdReservation = reservationService.createReservation(reservation);
	        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
	    }

	    //  update an existing reservation
	    @PutMapping("/reservation/{reservationId}")
	    public ResponseEntity<Reservations> updateReservation(
	            @PathVariable int reservationId,
	            @Validated @RequestBody Reservations updatedReservation) throws GlobalException {
	        Reservations existingReservation = reservationService.getReservationById(reservationId);

	        if (existingReservation != null) {
	            // Update fields
	            existingReservation.setCheckInDate(updatedReservation.getCheckInDate());
	            existingReservation.setCheckOutDate(updatedReservation.getCheckOutDate());
	            existingReservation.setTotalCost(updatedReservation.getTotalCost());
	            // Update other fields as needed

	            Reservations savedReservation = reservationService.createReservation(existingReservation);
	            return new ResponseEntity<>(savedReservation, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    //  delete a reservation by ID
	    @DeleteMapping("/reservation/{reservationId}")
	    public ResponseEntity<Void> deleteReservation(@PathVariable int reservationId) throws GlobalException {
	        Reservations existingReservation = reservationService.getReservationById(reservationId);

	        if (existingReservation != null) {
	            reservationService.deleteReservation(reservationId);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
 
}
