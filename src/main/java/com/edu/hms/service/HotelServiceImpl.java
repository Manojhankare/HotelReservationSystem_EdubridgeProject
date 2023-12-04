package com.edu.hms.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.Hotel;
import com.edu.hms.exceptions.GlobalException;
import com.edu.hms.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

    
    @Override
    public Hotel saveHotel(@Valid Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(int hId) throws GlobalException {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hId);
        return optionalHotel.orElseThrow(() -> new GlobalException("Hotel not found with ID: " + hId));
    }

    @Override
    public Hotel updateHotel(int hId, @Valid Hotel updatedHotel) throws GlobalException {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hId);

        if (optionalHotel.isPresent()) {
            updatedHotel.sethId(hId);
            return hotelRepository.save(updatedHotel);
        } else {
            throw new GlobalException("Hotel not found with ID: " + hId);
        }
    }

    @Override
    public void deleteHotel(int hId) throws GlobalException {
        // Check if the hotel with the given ID exists
        if (hotelRepository.existsById(hId)) {
            hotelRepository.deleteById(hId);
        } else {
            throw new GlobalException("Hotel not found with ID: " + hId);
        }
    }

    @Override
    public List<Hotel> searchByName(String name) {
        return hotelRepository.findByHnameContaining(name);
    }
    
    @Override
    public List<Hotel>searchByContactNo(int hno){
    	return hotelRepository.findByHno(hno);
    }

    @Override
    public List<Hotel> searchByCity(String city) {
        return hotelRepository.findByHcity(city);
    }

    @Override
    public List<Hotel> searchByOwner(int ownerId) {
        return hotelRepository.findByHotelOwnerOwnerId(ownerId);
    }
}

