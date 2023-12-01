package com.edu.hms.controller;

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
import com.edu.hms.exceptions.RoomNotFoundException;
import com.edu.hms.service.RoomService;

@Controller
 
	public class RoomController {

	    @Autowired
	    private RoomService roomService;

	    @PostMapping("/room/save")
	    public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
	        Room savedRoom = roomService.saveRoom(room);
	        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
	    }

	    @GetMapping("/room/get/{roomId}")
	    public ResponseEntity<Room> getRoomById(@PathVariable("roomId") int roomId) throws RoomNotFoundException {
	        Room room = roomService.getRoomById(roomId);
	        return new ResponseEntity<>(room, HttpStatus.OK);
	    }

	    @PutMapping("/room/update/{roomId}")
	    public ResponseEntity<Room> updateRoom(@PathVariable int roomId, @RequestBody Room updatedRoom) {
	        Room room = roomService.updateRoom(roomId, updatedRoom);
	        return new ResponseEntity<>(room, HttpStatus.OK);
	    }

	    @DeleteMapping("/room/delete/{roomId}")
	    public ResponseEntity<Void> deleteRoom(@PathVariable int roomId) {
	        roomService.deleteRoom(roomId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	     
	}
 