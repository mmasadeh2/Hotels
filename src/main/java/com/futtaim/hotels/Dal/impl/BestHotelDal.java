package com.futtaim.hotels.Dal.impl;

import com.futtaim.hotels.Dal.HotelDal;
import com.futtaim.hotels.models.BestHotel;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BestHotelDal implements HotelDal<BestHotel, Integer> {


    private List<BestHotel> bestHotelList = new ArrayList<>();

    @Override
    public BestHotel add(BestHotel bestHotel) {

        bestHotelList.add(bestHotel);
        return bestHotel;
    }

    @Override
    public void remove(BestHotel bestHotel) {

        bestHotelList.remove(bestHotel);


    }

    @Override
    public List<BestHotel> find(Integer key) {
        return bestHotelList.stream().filter(bestHotel -> bestHotel.getId().equals(key)).collect(Collectors.toList());
    }

    @Override
    public List<BestHotel> list(String fromDate, String toDate, String city, Integer numberOfAdults) {
        return bestHotelList.stream().filter(bestHotel -> bestHotel.getCity().equalsIgnoreCase(city) && bestHotel.getAdultNumber() >= numberOfAdults)
                .collect(Collectors.toList());
    }
}
