package com.edu.hms.service;

import com.edu.hms.entity.Room;
import com.edu.hms.exceptions.RoomNotFoundException;

public interface RoomService {

	Room saveRoom(Room room);

	Room getRoomById(int roomId) throws RoomNotFoundException;

	Room updateRoom(int roomId, Room updatedRoom);

	void deleteRoom(int roomId);
	
	

}
