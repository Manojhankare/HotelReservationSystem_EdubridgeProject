package com.edu.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.hms.entity.HotelOwner;

@Repository
public interface HotelOwnerRepository extends JpaRepository<HotelOwner, Integer>{

}
