package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.AirplaneDAO;
import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.FlightBookingsDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.model.Booking;
import com.ss.utopia.model.Flight;
import com.ss.utopia.model.FlightBookings;
import com.ss.utopia.model.Route;
import com.ss.utopia.model.User;
import com.ss.utopia.presentation.TravelerPresentation;

public class TravelerService {
    TravelerPresentation pres = new TravelerPresentation();
	Util util = new Util();
	
	public TravelerService() {
		// TODO Auto-generated constructor stub
	}

    public List<Route> readAllRoutes() throws SQLException {
    	Connection conn = null;
    	List<Route> routes = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		RouteDAO rdao = new RouteDAO(conn);
    		routes = rdao.readAllRoutes();
    		routes.forEach(r -> System.out.println(r.getOrgId()));
    	} catch (Exception e) {
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return routes;
    }
	
	
	public boolean verifyMembership(String username) {
	Connection conn = null;
	try {
    	
		conn = util.getConnection();
    	UserDAO udao = new UserDAO(conn);
		
    	List<String> memberships = new ArrayList<String>();
		
		for (User u : udao.readAllTravelers()) {
			//u.getUsername();
			memberships.add(u.getUsername());
		}
		return memberships.contains(username);
	} catch (Exception e) {
		System.out.println("problem on line 53 traveler service");
	}
	return false;
	
}

	public void createBooking(Booking booking, Flight flight) throws SQLException {
    	Connection conn = null;
    	try {
    		conn = util.getConnection();
    		FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
    	    BookingDAO bdao = new BookingDAO(conn);
            
    	   
    	    
    	    
    	    Integer bookingId = bdao.add(booking);
    	    
    	    
    	    
    	   
    	    
    	    fbdao.add(flight.getId(), bookingId);


    		

    		
    	    conn.commit();
    	    System.out.println("Booking added!");
    		
    		pres.menu();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
		
	}

	public List<Flight> readAllFlights() throws SQLException {
	  	Connection conn = null;
    	List<Flight> flights = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		FlightDAO fdao = new FlightDAO(conn);
    		flights = fdao.readAllFlights();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return flights;
		
	}

	public Flight findFlightById(Integer id) throws SQLException {
	   	Connection conn = null;
    	List<Flight> f = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		FlightDAO fdao = new FlightDAO(conn);
    		f = fdao.readFlightById(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return f.get(0);
	}
}
