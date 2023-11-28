package com.edu.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.hms.entity.HotelOwner;

@Repository
public interface HotelOwnerRepository extends JpaRepository<HotelOwner, Integer>{

	List<HotelOwner> findByOwnerNameAndOwnerEmailAndContactNumber(String ownerName, String ownerEmail,
			String contactNumber);

}
