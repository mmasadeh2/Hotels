package com.futtaim.hotels.Dal.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.futtaim.hotels.Dal.HotelDal;
import com.futtaim.hotels.models.CrazyHotel;

@Service
public class CrazyHotelDal implements HotelDal<CrazyHotel, Integer> {


    private List<CrazyHotel> crazyHotelList = new ArrayList<>();

    @Override
    public CrazyHotel add(CrazyHotel crazyHotel) {

        crazyHotelList.add(crazyHotel);
        return crazyHotel;
    }

    @Override
    public void remove(CrazyHotel crazyHotel) {

        crazyHotelList.remove(crazyHotel);


    }

    @Override
    public List<CrazyHotel> find(Integer key) {
        return crazyHotelList.stream().filter(crazyHotel -> crazyHotel.getId().equals(key)).collect(Collectors.toList());

    }

    @Override
    public List<CrazyHotel> list(String fromDate, String toDate, String city, Integer numberOfAdults) {
        return crazyHotelList.stream().filter(crazyHotel -> crazyHotel.getCity().equalsIgnoreCase(city) && crazyHotel.getAdultNumber() >= numberOfAdults)
                .collect(Collectors.toList());
    }
}
