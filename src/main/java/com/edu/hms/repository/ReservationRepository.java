package com.edu.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.hms.entity.Reservations;
 

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Integer>{

//	List<Reservations> findByHotel_HotelId(int hotelId);

//	List<Reservations> findByGuest_GuestId(int guestId);
	
	 @Query("SELECT r FROM Reservations r WHERE r.guest.id = :guestId")
	    List<Reservations> findByGuest_GuestId(@Param("guestId") int guestId);
	    
	  
	 @Query("SELECT r FROM Reservations r WHERE r.hotel.id = :hotelId")
	 	List<Reservations> findByHotel_HotelId(@Param("hotelId") int hotelId);
	    
}
