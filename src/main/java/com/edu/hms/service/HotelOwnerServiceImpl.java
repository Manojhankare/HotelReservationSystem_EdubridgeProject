package com.edu.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.edu.hms.entity.HotelOwner;
import com.edu.hms.repository.HotelOwnerRepository;

@Service
public class HotelOwnerServiceImpl implements HotelOwnerService {
	
	@Autowired HotelOwnerRepository hotelOwnerRepository;
	  
	@Override
    public HotelOwner saveHotelOwner(HotelOwner hotelOwner) {
        return hotelOwnerRepository.save(hotelOwner);
    }

    @Override
    public List<HotelOwner> getAllHotelOwners() {
        return hotelOwnerRepository.findAll();
    }

    @Override
    public HotelOwner getHotelOwnerById(Integer ownerId) {
        return hotelOwnerRepository.findById(ownerId).orElse(null);
    }

    @Override
    public HotelOwner updateHotelOwner(Integer ownerId, HotelOwner updatedHotelOwner) {
        HotelOwner existingHotelOwner = hotelOwnerRepository.findById(ownerId).orElse(null);
        if (existingHotelOwner != null) {
            // Update the fields you want to allow modification
            existingHotelOwner.setOwnerName(updatedHotelOwner.getOwnerName());
            existingHotelOwner.setOwnerEmail(updatedHotelOwner.getOwnerEmail());
            existingHotelOwner.setOwnerContactNumber(updatedHotelOwner.getOwnerContactNumber());
            existingHotelOwner.setOwnerUsername(updatedHotelOwner.getOwnerUsername());
            existingHotelOwner.setPassword(updatedHotelOwner.getPassword());

            return hotelOwnerRepository.save(existingHotelOwner);
        }
        return null;
    }

    @Override
    public void deleteHotelOwner(Integer ownerId) {
        hotelOwnerRepository.deleteById(ownerId);
    }

    @Override
    public List<HotelOwner> searchHotelOwners(String ownerName, String ownerEmail, String contactNumber) {
        HotelOwner searchCriteria = buildSearchCriteria(ownerName, ownerEmail, contactNumber);
        Example<HotelOwner> example = buildExampleFromCriteria(searchCriteria);

        return hotelOwnerRepository.findAll(example);
    }

    private HotelOwner buildSearchCriteria(String ownerName, String ownerEmail, String contactNumber) {
        HotelOwner searchCriteria = new HotelOwner();
        searchCriteria.setOwnerName(ownerName);
        searchCriteria.setOwnerEmail(ownerEmail);
        searchCriteria.setOwnerContactNumber(contactNumber);
        return searchCriteria;
    }

    private Example<HotelOwner> buildExampleFromCriteria(HotelOwner searchCriteria) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        return Example.of(searchCriteria, matcher);
    }
} 