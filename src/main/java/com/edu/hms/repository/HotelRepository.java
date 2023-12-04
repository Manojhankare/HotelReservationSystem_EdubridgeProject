package com.edu.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.hms.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

	List<Hotel> findByHcityAndHname(String city, String name);

	List<Hotel> findByHcity(String city);

	List<Hotel> findByHname(String name);

	List<Hotel> findByHotelOwnerOwnerId(int ownerId);

	List<Hotel> findByHnameContaining(String name);

	List<Hotel> findByHno(int hno);
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
