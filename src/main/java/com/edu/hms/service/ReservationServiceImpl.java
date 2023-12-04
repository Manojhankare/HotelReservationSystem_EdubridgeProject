package com.edu.hms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import com.edu.hms.entity.Reservations;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired 
	ReservationRepository reservationRepository;

 
	    @Override
	    public List<Reservations> getAllReservations() {
	        return reservationRepository.findAll();
	    }

	    @Override
	    public Reservations getReservationById(int reservationId) throws GlobalException {
	        return reservationRepository.findById(reservationId)
	                .orElseThrow(() -> new GlobalException("Reservation not found with id: " + reservationId));
	    }

	    @Override
	    public List<Reservations> getReservationsByGuest(int guestId) {
	        return reservationRepository.findByGuest_GuestId(guestId);
	    }

	    @Override
	    public List<Reservations> getReservationsByHotel(int hotelId) {
	        return reservationRepository.findByHotel_HotelId(hotelId);
	    }

	    @Override
	    public Reservations createReservation(Reservations reservation) throws GlobalException {
	        try {
	            // Calculate total cost and perform any additional validation
	            reservation.calculateTotalCost();

	            //  more validation logic here if needed

	            // Save the reservation to the database
	            return reservationRepository.save(reservation);
	        } catch (GlobalException e) {
	            // Handle the exception 
	            throw new GlobalException("Error creating reservation: " + e.getMessage());
	        }
	    }


	    @Override
	    public void deleteReservation(int reservationId) throws GlobalException {
	        if (!reservationRepository.existsById(reservationId)) {
	            throw new GlobalException("Reservation not found with id: " + reservationId);
	        }
	        reservationRepository.deleteById(reservationId);
	    }

		  

	}
	
