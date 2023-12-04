package com.edu.hms.service;

import java.util.List;

import com.edu.hms.entity.Reservations;
import com.edu.hms.exceptions.GlobalException;

public interface ReservationService {

	List<Reservations> getAllReservations();

	Reservations getReservationById(int reservationId) throws GlobalException;

	Reservations createReservation(Reservations reservation) throws GlobalException;

	void deleteReservation(int reservationId) throws GlobalException;

    List<Reservations> getReservationsByHotel(int hotelId);

	List<Reservations> getReservationsByGuest(int guestId);

}
