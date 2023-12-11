package com.edu.hms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.Hotel;
import com.edu.hms.entity.HotelDTO;
import com.edu.hms.entity.HotelOwner;
import com.edu.hms.entity.HotelOwnerDTO;
import com.edu.hms.entity.Room;
import com.edu.hms.entity.RoomDTO;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.repository.HotelOwnerRepository;
import com.edu.hms.repository.HotelRepository; 

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	 
	
	@Autowired
	private HotelOwnerRepository hotelOwnerRepository;
	
// follwing method used to store hotel without services list 
	@Override
	public Hotel saveHotel(@Valid Hotel hotel) throws GlobalException {
		if (hotel.getHotelName() == null || hotel.getHotelName().isEmpty()) {
			throw new GlobalException("Hotel name cannot be empty");
		}

		return hotelRepository.save(hotel);
	}
//	
	
//	public Hotel saveHotel(@Valid Hotel hotel) throws GlobalException {
//	    if (hotel.getHotelName() == null || hotel.getHotelName().isEmpty()) {
//	        throw new GlobalException("Hotel name cannot be empty");
//	    }
//
//	    // Save the hotel without services
//	    Hotel savedHotel = hotelRepository.save(hotel);
//
//	    // Set the hotel for each service and save them
//	    List<HotelServices> services = hotel.getHotelServices();
//	    if (services != null && !services.isEmpty()) {
//	        for (HotelServices service : services) {
//	            service.getHotels().add(savedHotel);
//	            hotelServicesRepository.save(service);
//	        }
//	    }
//
//	    return savedHotel;
//	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(int hotelId) throws GlobalException {
		Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
		return optionalHotel.orElseThrow(() -> new GlobalException("Hotel not found with ID: " + hotelId));
	}

	@Override
	public Hotel updateHotel(int hId, @Valid Hotel updatedHotel) throws GlobalException {
		Optional<Hotel> optionalHotel = hotelRepository.findById(hId);

		if (optionalHotel.isPresent()) {
			updatedHotel.setHotelId(hId);
			return hotelRepository.save(updatedHotel);
		} else {
			throw new GlobalException("Hotel not found with ID: " + hId);
		}
	}

	@Override
	public void deleteHotel(int hotelId) throws GlobalException {
		// Check if the hotel with the given ID exists
		if (hotelRepository.existsById(hotelId)) {
			hotelRepository.deleteById(hotelId);
		} else {
			throw new GlobalException("Hotel not found with ID: " + hotelId);
		}
	}

	@Override
	public List<Hotel> searchByName(String name) {
		return hotelRepository.findByHotelNameContaining(name);
	}

	@Override
	public List<Hotel> searchByContactNo(int hotelContactNo) {
		return hotelRepository.findByHotelContactNo(hotelContactNo);
	}

	@Override
	public List<Hotel> searchByCity(String city) {
		return hotelRepository.findByHotelCity(city);
	}

	@Override
	public List<Hotel> searchByOwnerId(int ownerId) {
		List<Hotel> hotels=hotelRepository.findByHotelOwnerOwnerId(ownerId);
		System.out.println(hotels);
		return hotels;
	}

	@Override
	public Hotel setHotelOwnerToHotel(int hotelId, int ownerId) throws GlobalException {
	    Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
	    if (!hotelOptional.isPresent()) {
	        throw new GlobalException("Hotel not exist");
	    }
	    Optional<HotelOwner> ownerOptional = hotelOwnerRepository.findById(ownerId);
	    if (!ownerOptional.isPresent()) {
	        throw new GlobalException("Hotel Owner not exist");
	    }
	    Hotel hotel = hotelOptional.get();
	    HotelOwner owner = ownerOptional.get();

	    hotel.setHotelOwner(owner);

	    return hotelRepository.save(hotel);
	}
	
//	@Override
//	public List<Hotel> getHotelsByOwnerId(int ownerId) throws GlobalException {
//	    try {
//	        return hotelRepository.findByHotelOwnerOwnerId(ownerId);
//	    } catch (Exception ex) {
//	        throw new GlobalException("Hotels not found for owner with id: " + ownerId);
//	    }
//	}

 
	@Override
	public List<Hotel> getHotelsByOwnerId(int ownerId) throws GlobalException {
	    List<Hotel> hotels = hotelRepository.findByHotelOwnerOwnerId(ownerId);

	    if (hotels.isEmpty()) {
	        throw new GlobalException("No hotels found for owner with id " + ownerId);
	    }

	    return hotels;
	}


	@Override
	public List<Hotel> searchByOwner(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	    public List<HotelDTO> getAllHotelDTOs() {
	        List<Hotel> hotels = hotelRepository.findAll();
	        return hotels.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public List<HotelDTO> getHotelDTOsByOwnerId(int ownerId) throws GlobalException {
	        List<Hotel> hotels = hotelRepository.findByHotelOwnerOwnerId(ownerId);

	        if (hotels.isEmpty()) {
	            throw new GlobalException("No hotels found for owner with id " + ownerId);
	        }

	        return hotels.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    private HotelDTO convertToDTO(Hotel hotel) {
	        HotelDTO hotelDTO = new HotelDTO();
	        hotelDTO.setHotelId(hotel.getHotelId());
	        hotelDTO.setHotelName(hotel.getHotelName());
	        hotelDTO.setHotelEmail(hotel.getHotelEmail());
	        hotelDTO.setHotelContactNo(hotel.getHotelContactNo());
	        hotelDTO.setHotelAddress(hotel.getHotelAddress());
	        hotelDTO.setHotelCity(hotel.getHotelCity());
	        hotelDTO.setHotelDescription(hotel.getHotelDescription());
	        hotelDTO.setHotelServices(hotel.getHotelServices());
	        hotelDTO.setHotelStatus(hotel.getHotelStatus());
	        hotelDTO.setHotelImgUrl(hotel.getHotelImgUrl());

	        // Convert HotelOwner to HotelOwnerDTO
	        HotelOwnerDTO ownerDTO = convertToDTO(hotel.getHotelOwner());
	        hotelDTO.setHotelOwner(ownerDTO);

	        // Convert Rooms to RoomDTOs
	        List<RoomDTO> roomDTOs = hotel.getRoom().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	        hotelDTO.setRooms(roomDTOs);

	        return hotelDTO;
	    }

	    private HotelOwnerDTO convertToDTO(HotelOwner owner) {
	        HotelOwnerDTO ownerDTO = new HotelOwnerDTO();
	        ownerDTO.setOwnerId(owner.getOwnerId());
	        ownerDTO.setOwnerName(owner.getOwnerName());
	        ownerDTO.setOwnerEmail(owner.getOwnerEmail());
	        ownerDTO.setOwnerContactNumber(owner.getOwnerContactNumber());
	        ownerDTO.setOwnerUsername(owner.getOwnerUsername());
	        return ownerDTO;
	    }

	    private RoomDTO convertToDTO(Room room) {
	        RoomDTO roomDTO = new RoomDTO();
	        roomDTO.setRoomId(room.getRoomId());
	        roomDTO.setRoomType(room.getRoomType());
	        roomDTO.setRoomPrice(room.getRoomPrice());
	        return roomDTO;
	    }

	 
}
