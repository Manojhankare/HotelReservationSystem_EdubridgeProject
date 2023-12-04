package com.edu.hms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.hms.entity.Room;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.service.RoomService;

@Controller

public class RoomController {

	@Autowired
	private RoomService roomService;

	@PostMapping("/room/save")
	public ResponseEntity<Room> saveRoom(@Valid @RequestBody Room room) {
		Room savedRoom = roomService.saveRoom(room);
		return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
	}

	@GetMapping("/room/getAll")
	public ResponseEntity<List<Room>> getAllRooms() {
		List<Room> rooms = roomService.getAllRooms();
		return new ResponseEntity<>(rooms, HttpStatus.OK);
	}

	@GetMapping("/room/getById/{rId}")
	public ResponseEntity<Room> getRoomById(@PathVariable("rId") int rId) throws GlobalException {
		Room room = roomService.getRoomById(rId);
		return new ResponseEntity<>(room, HttpStatus.OK);
	}

	@PutMapping("/room/update/{rId}")
	public ResponseEntity<Room> updateRoom(@PathVariable("rId") int rId, @Valid @RequestBody Room updatedRoom) throws GlobalException {
		Room room = roomService.updateRoom(rId, updatedRoom);
		return new ResponseEntity<>(room, HttpStatus.OK);
	}

	@DeleteMapping("/room/delete/{rId}")
	public ResponseEntity<Void> deleteRoom(@PathVariable("rId") int rId) {
		roomService.deleteRoom(rId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/room/searchByRoomType/{roomType}")
	public ResponseEntity<List<Room>> searchByRoomType(@PathVariable("roomType") String roomType) {
		List<Room> rooms = roomService.searchByRoomType(roomType);
		return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	
	@GetMapping("/room/searchByHotel/{hId}")
	public ResponseEntity<List<Room>> searchByHotel(@PathVariable("hId") int hId) {
	    List<Room> rooms = roomService.searchByHotel(hId);
	    return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	
	@GetMapping("/room/searchByCapacity/{adults}/{children}")
	public ResponseEntity<List<Room>> searchByCapacity(@PathVariable("adults") int adults, @PathVariable("children") int children) {
	    List<Room> rooms = roomService.searchByCapacity(adults, children);
	    return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	
	@GetMapping("/room/filterByPrice/{minPrice}/{maxPrice}")
	public ResponseEntity<List<Room>> filterByPrice(@PathVariable("minPrice") double minPrice, @PathVariable("maxPrice") double maxPrice) {
	    List<Room> rooms = roomService.filterByPrice(minPrice, maxPrice);
	    return new ResponseEntity<>(rooms, HttpStatus.OK);
	}

	@GetMapping("/room/getAvailableRooms")
	public ResponseEntity<List<Room>> getAvailableRooms() {
	    List<Room> rooms = roomService.getAvailableRooms();
	    return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	
	@GetMapping("/room/getReservedRooms")
	public ResponseEntity<List<Room>> getReservedRooms() {
	    List<Room> rooms = roomService.getReservedRooms();
	    return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	
	@GetMapping("/room/getReservedRooms/{startDate}/{endDate}")
	public ResponseEntity<List<Room>> getReservedRooms(
	        @PathVariable("startDate") String startDate,
	        @PathVariable("endDate") String endDate) {
	    List<Room> rooms = roomService.getReservedRooms(startDate, endDate);
	    return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
 
}