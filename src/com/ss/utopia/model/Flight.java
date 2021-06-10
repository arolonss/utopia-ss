package com.ss.utopia.model;

import java.sql.Time;

public class Flight {

	private Integer id;
	private Route routeId;
	private Time depTime;
	private Integer reservedSeats;
	private Float seatPrice;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the routeId
	 */
	public Route getRouteId() {
		return routeId;
	}
	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(Route routeId) {
		this.routeId = routeId;
	}
	/**
	 * @return the depTime
	 */
	public Time getDepTime() {
		return depTime;
	}
	/**
	 * @param depTime the depTime to set
	 */
	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}
	/**
	 * @return the reservedSeats
	 */
	public Integer getReservedSeats() {
		return reservedSeats;
	}
	/**
	 * @param reservedSeats the reservedSeats to set
	 */
	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	/**
	 * @return the seatPrice
	 */
	public Float getSeatPrice() {
		return seatPrice;
	}
	/**
	 * @param seatPrice the seatPrice to set
	 */
	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	
}
