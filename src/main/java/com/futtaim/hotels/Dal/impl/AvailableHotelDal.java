package com.futtaim.hotels.Dal.impl;

import com.futtaim.hotels.Dal.HotelDal;
import com.futtaim.hotels.models.BestHotel;
import com.futtaim.hotels.models.CrazyHotel;
import com.futtaim.hotels.models.DTOHotel;
import com.futtaim.hotels.models.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailableHotelDal implements HotelDal<DTOHotel, Integer> {

    @Autowired
    private BestHotelDal bestHotelDal;

    @Autowired
    private CrazyHotelDal crazyHotelDal;

    private List<DTOHotel> dtoHotelList = new ArrayList<>();

    @Override
    public DTOHotel add(DTOHotel dtoHotel) {
        dtoHotelList.add(dtoHotel);
        return dtoHotel;
    }

    @Override
    public void remove(DTOHotel dtoHotel) {
        dtoHotelList.remove(dtoHotel);

    }

    @Override
    public List<DTOHotel> find(Integer key) {
        return dtoHotelList.stream().filter(dtoHotel -> dtoHotel.getId().equals(key)).collect(Collectors.toList());
    }

    @Override
    public List<DTOHotel> list(String fromDate, String toDate, String city, Integer numberOfAdults) {

        List<BestHotel> bestHotelList = bestHotelDal.list(fromDate, toDate, city, numberOfAdults);
        List<CrazyHotel> crazyHotelList = crazyHotelDal.list(fromDate, toDate, city, numberOfAdults);

        List<DTOHotel> dtoHotelList = new ArrayList<>();

        convertBestToDTO(bestHotelList, dtoHotelList);

        convertCrazyToDTO(crazyHotelList, dtoHotelList);


        return dtoHotelList.stream().sorted(Comparator.comparing(DTOHotel::getRate).reversed()).collect(Collectors.toList());
    }

    private void convertCrazyToDTO(List<CrazyHotel> crazyHotelList, List<DTOHotel> dtoHotelList) {
        for (CrazyHotel crazyHotel : crazyHotelList) {
            DTOHotel dtoHotel = new DTOHotel();
            dtoHotel.setId(crazyHotel.getId());
            dtoHotel.setFromDate(crazyHotel.getFromDate());
            dtoHotel.setToDate(crazyHotel.getToDate());
            dtoHotel.setAmenities(crazyHotel.getAmenities());
            dtoHotel.setCity(crazyHotel.getCity());
            dtoHotel.setProvider(Provider.CRAZY);
            dtoHotel.setHotelName(crazyHotel.getHotelName());
            dtoHotel.setRate((int) crazyHotel.getRate().chars().filter(ch -> ch == '*').count());
            dtoHotelList.add(dtoHotel);
        }
    }

    private void convertBestToDTO(List<BestHotel> bestHotelList, List<DTOHotel> dtoHotelList) {
        for (BestHotel bestHotel : bestHotelList) {
            DTOHotel dtoHotel = new DTOHotel();
            dtoHotel.setId(bestHotel.getId());
            dtoHotel.setFromDate(bestHotel.getFromDate());
            dtoHotel.setToDate(bestHotel.getToDate());
            dtoHotel.setAmenities(Arrays.asList(bestHotel.getRoomAmenities().split(",")));
            dtoHotel.setCity(bestHotel.getCity());
            dtoHotel.setFare(bestHotel.getHotelFare());
            dtoHotel.setProvider(Provider.BEST);
            dtoHotel.setHotelName(bestHotel.getHotel());
            dtoHotel.setRate(bestHotel.getHotelRate());
            dtoHotel.setAdultNumber(bestHotel.getAdultNumber());
            dtoHotelList.add(dtoHotel);
        }
    }
}
