package com.edu.hms.service;

import java.util.List;

import com.edu.hms.entity.Room;
import com.edu.hms.exceptions.GlobalException;

public interface RoomService {

	Room saveRoom(Room room);

	Room getRoomById(int roomId) throws GlobalException;

	Room updateRoom(int roomId, Room updatedRoom) throws GlobalException;

	void deleteRoom(int roomId);

	List<Room> getAllRooms();

	List<Room> searchByRoomType(String roomType);

	List<Room> searchByHotel(int hId);

	List<Room> filterByPrice(double minPrice, double maxPrice);

	List<Room> searchByCapacity(int adults, int children);

	List<Room> getAvailableRooms();

	List<Room> getReservedRooms();

	List<Room> getReservedRooms(String startDate, String endDate);

}
