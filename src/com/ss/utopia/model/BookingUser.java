package com.ss.utopia.model;

public class BookingUser {

	private Booking bookingId;
	private User userId;
	/**
	 * @return the bookingId
	 */
	public Booking getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the userId
	 */
	public User getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	
}
