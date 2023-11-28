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

}
