package com.futtaim.hotels.service.impl;

import com.futtaim.hotels.Dal.impl.AvailableHotelDal;
import com.futtaim.hotels.models.DTOHotel;
import com.futtaim.hotels.service.AvailabletHotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableHotelServiceImpl implements AvailabletHotelService {

    /**
     *
     */
    @Autowired
    private AvailableHotelDal availableHotelDao;

    /*
     * (non-Javadoc)
     *
     * @see com.futaim.beam.service.HotelService#getHotel(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.Integer)
     */
    @Override
    public List<DTOHotel> getHotel(String fromDate, String toDate, String city, Integer numberOfAdults) {
        return availableHotelDao.list(fromDate, toDate, city, numberOfAdults);
    }

    @Override
    public DTOHotel setHotel(DTOHotel availableHotel
    ) {
        return availableHotelDao.add(availableHotel);
    }
}
