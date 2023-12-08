package com.edu.hms.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.Hotel;
import com.edu.hms.entity.HotelOwner;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.repository.HotelOwnerRepository;
import com.edu.hms.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private HotelOwnerRepository hotelOwnerRepository;

	@Override
	public Hotel saveHotel(@Valid Hotel hotel) throws GlobalException {
		if (hotel.getHotelName() == null || hotel.getHotelName().isEmpty()) {
			throw new GlobalException("Hotel name cannot be empty");
		}

		return hotelRepository.save(hotel);
	}

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
	public List<Hotel> searchByOwner(int ownerId) {
		return hotelRepository.findByHotelOwnerOwnerId(ownerId);
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
	
	@Override
	public List<Hotel> getHotelsByOwnerId(int ownerId) {
        return hotelRepository.findByHotelOwnerOwnerId(ownerId);
//                .orElseThrow(() -> new GlobalException("Hotels not found for owner with id: " + ownerId));
        
        
    }
//	@Override
//	public Hotel getHotelByOwnerId(int ownerId) throws GlobalException {
//		Hotel h= HotelRepository.find(ownerId);
//	
//		Hotel h1=null;
//		if(h == null) {
//			throw new GlobalException("Hotel Admin with id "+ownerId+" not found");
//		}
//		System.out.println(ownerId);
//		
//		h1=HotelRepository.findByHotelOwnerOwnerId(ownerId);
//		System.out.println(h1);
//		return h1;	
//}

}
