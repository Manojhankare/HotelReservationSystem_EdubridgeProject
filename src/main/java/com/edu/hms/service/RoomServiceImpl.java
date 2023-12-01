package com.edu.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.Room;
import com.edu.hms.exceptions.RoomNotFoundException;
import com.edu.hms.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room saveRoom(Room room) {
		// TODO Auto-generated method stub
		roomRepository.save(room);
		return null;
	}

	@Override
	public Room getRoomById(int roomId) throws RoomNotFoundException {
		   return roomRepository.findById(roomId)
		            .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + roomId));
	}

	@Override
	public Room updateRoom(int roomId, Room updatedRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRoom(int roomId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
