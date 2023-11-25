package com.edu.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.hms.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
	
//	@Query
//	 @Query("SELECT g FROM Guest g WHERE g.gusername = :username")
//	    List<Guest> findByUsername(@Param("username") String username);

}
