package com.ss.utopia.model;

public class BookingGuest {
	private Booking bookingId;
	private String email;
	private String phone;

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
