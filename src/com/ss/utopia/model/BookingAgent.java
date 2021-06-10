package com.ss.utopia.model;


public class BookingAgent {
	private Booking bookingNo;
	private User agentId;
	/**
	 * @return the bookingId
	 */
	public Booking getBookingNo() {
		return bookingNo;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingNo(Booking bookingNo) {
		this.bookingNo = bookingNo;
	}
	/**
	 * @return the agentId
	 */
	public User getAgentId() {
		return agentId;
	}
	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(User agentId) {
		this.agentId = agentId;
	}
	
	
}
