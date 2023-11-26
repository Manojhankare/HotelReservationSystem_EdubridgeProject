package com.edu.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired ReservationRepository reservationRepository;
	
	

}
