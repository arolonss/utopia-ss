package com.ss.utopia.model;


public class Booking {
	private Integer bookingNo;
	private Integer is_active;
	private String confCode;
	/**
	 * @return the bookingNo
	 */
	public Integer getBookingNo() {
		return bookingNo;
	}
	/**
	 * @param bookingNo the bookingNo to set
	 */
	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}

	/**
	 * @return the is_active
	 */
	public Integer getIs_active() {
		return is_active;
	}
	/**
	 * @param is_active the is_active to set
	 */
	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}
	/**
	 * @return the confCode
	 */
	public String getConfCode() {
		return confCode;
	}
	/**
	 * @param confCode the confCode to set
	 */
	public void setConfCode(String confCode) {
		this.confCode = confCode;
	}
	
}
