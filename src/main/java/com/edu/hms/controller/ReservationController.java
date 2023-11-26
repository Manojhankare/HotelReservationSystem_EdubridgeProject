package com.edu.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.edu.hms.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired ReservationService reservationService;

}
