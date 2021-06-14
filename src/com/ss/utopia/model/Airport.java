/**
 * 
 */
package com.ss.utopia.model;

import java.util.List;

public class Airport {



	private String airportCode; 
	private String city;
	//private List<Route> routes;
	
	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", city=" + city + "]";
	}
	/**
	 * @return the airportCode
	 */
	public String getAirportCode() {
		return airportCode;
	}
	/**
	 * @param airportCode the airportCode to set
	 */
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
//	/**
//	 * @return the routes
//	 */
//	public List<Route> getRoutes() {
//		return routes;
//	}
//	/**
//	 * @param routes the routes to set
//	 */
//	public void setRoutes(List<Route> routes) {
//		this.routes = routes;
//	}

	
}
