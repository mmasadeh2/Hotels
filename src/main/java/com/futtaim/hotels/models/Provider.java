package com.futtaim.hotels.models;

public enum Provider {

	BEST(1), CRAZY(2);

	/**
	 * 
	 */
	private final int hotelCode;

	/**
	 * @param hotelCode
	 */
	Provider(int hotelCode) {
		this.hotelCode = hotelCode;

	}

	/**
	 * @return
	 */
	public int getHotelCode() {
		return hotelCode;
	}
}
