package com.edu.hms.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.edu.hms.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

	boolean existsByGuestEmail(String guestEmail);

	boolean existsByGuestContactNo(String guestContactNo);

	boolean existsByGuestUsername(String guestUsername);

	Guest findByGuestUsernameAndGuestPass(String username, String password);
	
	@Query(value = "SELECT * FROM Guest WHERE username=?1" , nativeQuery=true)
	Guest findByGuestByUsername(String username);
	
//	@Query
//	 @Query("SELECT g FROM Guest g WHERE g.gusername = :username")
//	    List<Guest> findByUsername(@Param("username") String username);

}
