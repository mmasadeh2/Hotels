package com.futtaim.hotels.service.impl;

import com.futtaim.hotels.Dal.impl.BestHotelDal;
import com.futtaim.hotels.models.BestHotel;
import com.futtaim.hotels.service.BestHotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestHotelServiceImpl implements BestHotelService {
    /*
     *
     */
    @Autowired
    private BestHotelDal bestHotelDao;

    /*
     * (non-Javadoc)
     *
     * @see com.futaim.beam.service.HotelService#getHotel(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.Integer)
     */
    @Override
    public List<BestHotel> getHotel(String fromDate, String toDate, String city, Integer numberOfAdults) {
        return bestHotelDao.list(fromDate, toDate, city, numberOfAdults);
    }

    @Override
    public BestHotel setHotel(BestHotel bestHotel) {
        return bestHotelDao.add(bestHotel);
    }
}
