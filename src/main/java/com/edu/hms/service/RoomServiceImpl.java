package com.edu.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.repository.RoomRepository;

@Service
public class RoomServiceImpl {
	
	@Autowired
	private RoomRepository roomRepository;
	
	

}
