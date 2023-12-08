package com.edu.hms.repository;

import java.util.List;
 

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.hms.entity.HotelOwner;

@Repository
public interface HotelOwnerRepository extends JpaRepository<HotelOwner, Integer> {

//	boolean existsByOwnerEmail(String email);
//
//	boolean existsByOwnerContactNumber(String contactNumber);

	@Query("SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END FROM HotelOwner h WHERE h.ownerEmail = :email")
	boolean existsByOwnerEmail(@Param ("email") String email);

	@Query("SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END FROM HotelOwner h WHERE h.ownerContactNumber = :contactNumber")
	boolean existsByOwnerContactNumber(@Param("contactNumber") String contactNumber);
	
	@Query("SELECT CASE When COUNT(h) > 0 THEN true ELSE false END FROM HotelOwner h where h.ownerUsername = :username")
	boolean existsByOwnerUsername(@Param("username")String username);


	List<HotelOwner> findByOwnerNameAndOwnerEmailAndOwnerContactNumber(String ownerName, String ownerEmail,
			String ownercontactNumber);
	
//	@Query(value = "SELECT * FROM HotelOwner WHERE ownerUsername=?1" , nativeQuery=true)
//	HotelOwner findByHotelOwnerByOwnerUsername(String username);
	
	@Query(value = "SELECT * FROM hotel_owner WHERE owner_username = :username", nativeQuery = true)
	HotelOwner findByOwnerUsername(@Param("username") String username);


}
