package com.futtaim.hotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futtaim.hotels.models.DTOHotel;
import com.futtaim.hotels.service.AvailabletHotelService;


@RestController
@RequestMapping(value = "/availableHotel")
public class AvailableHotelController {

	/**
	 * 
	 */
	@Autowired
	private AvailabletHotelService availableHotelService;

	/**
	 * @param fromDate
	 * @param toDate
	 * @param city
	 * @param numberOfAdults
	 * @return
	 */
	@GetMapping
	public List<DTOHotel> findAllAvailableHotels(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String city, @RequestParam Integer numberOfAdults) {
		List<DTOHotel> hotel = availableHotelService.getHotel(fromDate, toDate, city, numberOfAdults);
		return hotel;
	}
}