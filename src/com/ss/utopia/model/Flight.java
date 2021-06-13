package com.ss.utopia.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Flight {

	private Integer id;
	private Route routeId;
	private Airplane airplaneId;
	private Timestamp depTime;
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
	@Override
	public String toString() {
		return "Flight [id=" + id + ", routeId=" + routeId + ", airplaneId=" + airplaneId + ", depTime=" + depTime
				+ ", reservedSeats=" + reservedSeats + ", seatPrice=" + seatPrice + "]";
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
	 * @return the airplaneId
	 */
	public Airplane getAirplaneId() {
		return airplaneId;
	}
	/**
	 * @param airplaneId the airplaneId to set
	 */
	public void setAirplaneId(Airplane airplaneId) {
		this.airplaneId = airplaneId;
	}
	/**
	 * @return the depTime
	 */
	public Timestamp getDepTime() {
		return depTime;
	}
	/**
	 * @param time the depTime to set
	 */
	public void setDepTime(Timestamp time) {
		this.depTime = time;
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
