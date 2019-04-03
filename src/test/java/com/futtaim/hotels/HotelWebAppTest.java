package com.futtaim.hotels;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.futtaim.hotels.models.BestHotel;
import com.futtaim.hotels.models.CrazyHotel;
import com.futtaim.hotels.service.AvailabletHotelService;
import com.futtaim.hotels.service.BestHotelService;
import com.futtaim.hotels.service.CrazyHotelService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class HotelWebAppTest {

	/**
	 *
	 */
	@Autowired
	private BestHotelService bestHotelService;

	@Autowired
	private CrazyHotelService crazyHotelService;

	@Autowired
	private AvailabletHotelService availabletHotelService;

	/**
	 * @throws IOException
	 */
	@Before
	public void addBestAndHotel() throws Exception {

		BestHotel bestHotel = new BestHotel();
		bestHotel.setHotel("Hyatt Regency");
		bestHotel.setHotelFare(36);
		bestHotel.setHotelRate(5);
		bestHotel.setRoomAmenities("Room 1,Room 2,Room 3,Room 4");
		bestHotel.setCity("Amman");
		bestHotel.setId(1);
		bestHotel.setAdultNumber(2);
		Date fromDate = new Date();
		Date toDate = new Date();

		bestHotel.setFromDate(fromDate);
		bestHotel.setFromDate(toDate);
		bestHotelService.setHotel(bestHotel);

		//////////////////////////////////////

		BestHotel bestHotel2 = new BestHotel();
		bestHotel2.setHotel("Al Jamal Hotel");
		bestHotel2.setHotelFare(36);
		bestHotel2.setHotelRate(5);
		bestHotel2.setRoomAmenities("Room 1,Room 2,Room 3,Room 4");
		bestHotel2.setCity("Amman");
		bestHotel2.setId(2);
		bestHotel2.setAdultNumber(2);
		Date fromDate1 = new Date();
		Date toDate1 = new Date();

		bestHotel2.setFromDate(fromDate1);
		bestHotel2.setFromDate(toDate1);
		bestHotelService.setHotel(bestHotel2);

		//////////////////////////////////////

		CrazyHotel crazyHotel = new CrazyHotel();
		crazyHotel.setHotelName("Toledo Hotel");
		crazyHotel.setRate("***");
		crazyHotel.setAmenities(Arrays.asList("Room 1,Room 2,Room 3,Room 4"));
		crazyHotel.setCity("Amman");
		crazyHotel.setId(3);
		crazyHotel.setAdultNumber(2);
		Date fromDate2 = new Date();
		Date toDate2 = new Date();

		crazyHotel.setFromDate(fromDate2);
		crazyHotel.setFromDate(toDate2);
		crazyHotelService.setHotel(crazyHotel);

		//////////////////////////////////////

		CrazyHotel crazyHotel1 = new CrazyHotel();
		crazyHotel1.setHotelName("Mariam Hotel");
		crazyHotel1.setRate("**");
		crazyHotel1.setAmenities(Arrays.asList("Room 1,Room 2,Room 3,Room 4"));
		crazyHotel1.setCity("Amman");
		crazyHotel1.setId(4);
		crazyHotel1.setAdultNumber(2);
		Date fromDate3 = new Date();
		Date toDate3 = new Date();

		crazyHotel1.setFromDate(fromDate3);
		crazyHotel1.setFromDate(toDate3);
		crazyHotelService.setHotel(crazyHotel1);

	}

	/**
	 * 
	 */
	@Test
	public void getAvailableHotels() {
		assertNotNull(availabletHotelService.getHotel("2019-04-01", "2019-04-25", "Amman", 2));
	}

	/**
	 * 
	 */
	@Test
	public void getBestHotel() {
		List<BestHotel> bestHotelList = bestHotelService.getHotel("2019-04-01", "2019-04-25", "Amman", 2);
		assertTrue(bestHotelList.size() >= 0);
	}

	/**
	 * 
	 */
	@Test
	public void getCrazyHotel() {
		List<CrazyHotel> crazyHotelList = crazyHotelService.getHotel("2019-04-01", "2019-04-25", "Amman", 2);
		assertEquals(crazyHotelList.size(), 0);
	}
}