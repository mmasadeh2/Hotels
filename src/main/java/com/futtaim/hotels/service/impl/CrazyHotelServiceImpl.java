package com.futtaim.hotels.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futtaim.hotels.Dal.impl.CrazyHotelDal;
import com.futtaim.hotels.models.CrazyHotel;
import com.futtaim.hotels.service.CrazyHotelService;

@Service
public class CrazyHotelServiceImpl implements CrazyHotelService {

    /**
     *
     */
    @Autowired
    private CrazyHotelDal crazyHotelDao;
    /*
     * (non-Javadoc)
     *
     * @see com.futaim.beam.service.HotelService#getHotel(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.Integer)
     */
    @Override
    public List<CrazyHotel> getHotel(String fromDate, String toDate, String city, Integer numberOfAdults) {
        return crazyHotelDao.list(fromDate, toDate, city, numberOfAdults);
    }

    @Override
    public CrazyHotel setHotel(CrazyHotel crazyHotel) {
        return crazyHotelDao.add(crazyHotel);
    }
}
