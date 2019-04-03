package com.futtaim.hotels.service;

import org.springframework.stereotype.Service;

import com.futtaim.hotels.models.Hotel;

import java.util.List;

@Service
public interface HotelService<T extends Hotel> {
    /**
     * @param fromDate
     * @param toDate
     * @param city
     * @param numberOfAdults
     * @return
     */
    List<T> getHotel(String fromDate, String toDate, String city, Integer numberOfAdults);

    T setHotel(T hotel);
}
