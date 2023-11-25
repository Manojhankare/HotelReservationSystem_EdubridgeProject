package com.edu.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.hms.entity.Reservations;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Integer>{

}
