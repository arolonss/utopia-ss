package com.ss.utopia.model;

public class BookingPayment {

	private Booking bookingId;
	private String stripeId;
	private boolean refunded;
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
	 * @return the stripeId
	 */
	public String getStripeId() {
		return stripeId;
	}
	/**
	 * @param stripeId the stripeId to set
	 */
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	/**
	 * @return the refunded
	 */
	public boolean isRefunded() {
		return refunded;
	}
	/**
	 * @param refunded the refunded to set
	 */
	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}
	
	
}
