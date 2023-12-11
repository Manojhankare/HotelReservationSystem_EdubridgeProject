package com.edu.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.hms.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

	List<Hotel> findByHotelCityAndHotelName(String city, String name);

	List<Hotel> findByHotelCity(String city);

	List<Hotel> findByHotelName(String name);

//	Hotel findByHotelOwnerOwnerId(int ownerId);

	List<Hotel> findByHotelNameContaining(String name);

	List<Hotel> findByHotelContactNo(int hotelContactNo);
	@Query(value="select * from hotel where hotel_owner_owner_id=?", nativeQuery = true)
//	public List<Hotel> findByHotelOwnerId(int hotelOwner);
	
//	List<Hotel> findByHotelOwnerOwnerId(int ownerId);

	List<Hotel> findByHotelOwnerOwnerId(int ownerId);
	
//	 Optional<Hotel> findByHotelOwnerId(int ownerId);
	
	
	
	
	
	
	
	
	
	
	
//	
//	  @Query("SELECT h FROM Hotel h WHERE h.hcity = :city AND h.hname = :name")
//	    List<Hotel> findByCityAndName(@Param("city") String city, @Param("name") String name);
//
//	    @Query("SELECT h FROM Hotel h WHERE h.hcity = :city")
//	    List<Hotel> findByCity(@Param("city") String city);
//
//	    @Query("SELECT h FROM Hotel h WHERE h.hname = :name")
//	    List<Hotel> findByName(@Param("name") String name);
//
//	    @Query("SELECT h FROM Hotel h WHERE h.hotelOwner.ownerId = :ownerId")
//	    List<Hotel> findByOwnerId(@Param("ownerId") int ownerId);
//
//	    @Query("SELECT h FROM Hotel h WHERE h.hname LIKE %:name%")
//	    List<Hotel> findByNameContaining(@Param("name") String name);
//
//	    @Query("SELECT h FROM Hotel h WHERE h.hno = :hno")
//	    List<Hotel> findByContactNo(@Param("hno") int hno);

	

	 

}
