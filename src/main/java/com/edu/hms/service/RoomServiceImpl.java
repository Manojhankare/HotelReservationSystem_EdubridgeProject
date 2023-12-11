package com.edu.hms.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.Room;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room saveRoom(@Valid Room room) {
		return roomRepository.save(room);
	}

	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public Room getRoomById(int rId) throws GlobalException {
		return roomRepository.findById(rId).orElseThrow(() -> new GlobalException("Room not found with ID: " + rId));
	}

	@Override
	@Transactional
	public Room updateRoom(int rId, @Valid Room updatedRoom) throws GlobalException {
		Room existingRoom = getRoomById(rId);

		// Update properties of the existing room with the new values
		existingRoom.setRoomNo(updatedRoom.getRoomNo());
		existingRoom.setRoomType(updatedRoom.getRoomType());
		existingRoom.setRoomPrice(updatedRoom.getRoomPrice());
		existingRoom.setRoomcapacityAdults(updatedRoom.getRoomcapacityAdults());
		existingRoom.setRoomcapacityChildren(updatedRoom.getRoomcapacityChildren());

		return existingRoom;
	}

	@Override
	public void deleteRoom(int rId) {
		roomRepository.deleteById(rId);
	}

	@Override
	public List<Room> searchByRoomType(String roomType) {
		return roomRepository.findByRoomTypeContaining(roomType);
	}


    @Override
    public List<Room> searchByHotel(int hId) {
        return roomRepository.findByHotelId(hId);
    }

    @Override
    public List<Room> searchByCapacity(int adults, int children) {
        return roomRepository.findByRoomcapacityAdultsAndRoomcapacityChildren(adults, children);
    }

    @Override
    public List<Room> filterByPrice(double minPrice, double maxPrice) {
        return roomRepository.findByRoomPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Room> getAvailableRooms() { 
        return roomRepository.findRoomsWithNoReservations();
    }

    @Override
    public List<Room> getReservedRooms() {
 
        return roomRepository.findRoomsWithReservations();
    }

    @Override
    public List<Room> getReservedRooms(String startDate, String endDate) { 
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        return roomRepository.findReservedRoomsByDateRange(start, end);
    }

}
