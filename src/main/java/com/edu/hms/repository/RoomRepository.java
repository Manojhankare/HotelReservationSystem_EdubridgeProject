package com.edu.hms.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.hms.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	List<Room> findByRoomTypeContaining(String roomType);

// 
//    List<Room> findByHotel_HId(int hId);
	@Query("SELECT r FROM Room r WHERE r.hotel.hotelId = :hotelId")
    List<Room> findByHotelId(@Param("hotelId") int hotelId);

	List<Room> findByRoomcapacityAdultsAndRoomcapacityChildren(int adults, int children);


	List<Room> findByRoomPriceBetween(double minPrice, double maxPrice);
 
	
	 @Query("SELECT r FROM Room r WHERE r.reservation IS NULL")
	    List<Room> findRoomsWithNoReservations();

	    // Find rooms with reservations
	    @Query("SELECT r FROM Room r WHERE r.reservation IS NOT NULL")
	    List<Room> findRoomsWithReservations();

	    // Find rooms reserved during the specified period
	    @Query("SELECT r FROM Room r WHERE r.reservation.checkInDate >= :startDate AND r.reservation.checkOutDate <= :endDate")
	    List<Room> findReservedRoomsByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
 
}
