package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.AirplaneDAO;
import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.dao.UserRoleDAO;
import com.ss.utopia.model.Airplane;
import com.ss.utopia.model.Airport;
import com.ss.utopia.model.Booking;
import com.ss.utopia.model.Flight;
import com.ss.utopia.model.Route;
import com.ss.utopia.model.User;
import com.ss.utopia.model.UserRole;
import com.ss.utopia.presentation.admin.AdminPresentation;

public class AdminService {
    AdminPresentation pres = new AdminPresentation();


	Util util = new Util();

    public void addFlight(Integer id, Route routeId, Airplane airplane, Timestamp dTime, Integer reservedSeats, Float seatPrice) throws SQLException {
    	Connection conn = null;
    	try {
    		conn = util.getConnection();
    		FlightDAO fdao = new FlightDAO(conn);
    	    RouteDAO rdao = new RouteDAO(conn);
    	    AirplaneDAO adao = new AirplaneDAO(conn);
    	    Flight f = new Flight();
            
    		System.out.println(airplane);
    		rdao.addRoute(routeId);
    	    //adao.add(airplane);
    	   
    	    
    		f.setId(id);
    		f.setRouteId(routeId);
    		f.setAirplaneId(airplane);
    		f.setDepTime(dTime);
    		f.setReservedSeats(reservedSeats);
    		f.setSeatPrice(seatPrice);
//    		System.out.println(flight.getRouteId().getDestId());
//    		System.out.println(flight.getAirplaneId());
//    		System.out.println(flight.getDepTime());
//    		System.out.println(flight.getReservedSeats());
//    		System.out.println(flight.getSeatPrice());
//    		System.out.println(flight.getId());
//    		System.out.println(flight.getRouteId().getId());
//    		System.out.println(flight.getAirplaneId().getTypeId());
//    		System.out.println(flight.getDepTime());
    	    System.out.println(routeId);
    	    System.out.println(airplane);
    		System.out.println(f.toString());
    		

    		fdao.addFlight(f);
    	    conn.commit();
    	    System.out.println("Flight added!");
    		
    		pres.menu();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    }
	
	
    public void addRoute(Route route) throws SQLException {
    	Connection conn = null;
    	try {
    		conn = util.getConnection();
    		RouteDAO rdao = new RouteDAO(conn);
    	    // check airptCodes
    	    conn.commit();
    	} catch (Exception e) {
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    }
    
    public List<Route> readAllRoutes() throws SQLException {
    	Connection conn = null;
    	List<Route> routes = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		RouteDAO rdao = new RouteDAO(conn);
    		routes = rdao.readAllRoutes();
    	} catch (Exception e) {
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return routes;
    }


	public List<UserRole> readAllUserRoles() throws SQLException {
    	Connection conn = null;
    	List<UserRole> urs = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		UserRoleDAO urdao = new UserRoleDAO(conn);
    		urs = urdao.readAll();
    	} catch (Exception e) {
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return urs;
		
	}


	public void addUser(User u) throws SQLException {
    	Connection conn = null;
    	try {
    		conn = util.getConnection();
    		UserDAO udao = new UserDAO(conn);
    		
    	    System.out.println(u.getRole());
    	    System.out.println(u.getFirstName());
    	    System.out.println(u.getLastName());
    	    System.out.println(u.getUsername());
    	    System.out.println(u.getEmail());
    	    System.out.println(u.getPassword());
    	    System.out.println(u.getPhone());
    	
    	    udao.add(u);
    	    conn.commit();
    	    System.out.println("Request completed!");
    	    
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
		
	}
	
	public List<User> readAllAgents() throws SQLException {
    	Connection conn = null;
    	List<User> agents = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		UserDAO udao = new UserDAO(conn);
    		agents = udao.readAllAgents();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return agents;
		
	}


	public User readUserById(Integer id) throws SQLException {
    	Connection conn = null;
    	List<User> u = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		UserDAO udao = new UserDAO(conn);
    		u = udao.readById(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return u.get(0);
		
	}


	public User readAgentById(Integer id) throws SQLException {
	   	Connection conn = null;
    	List<User> u = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		UserDAO udao = new UserDAO(conn);
    		u = udao.readAgentById(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return u.get(0);
	}
	
	public void deleteAgent(Integer id) throws SQLException {
	   	Connection conn = null;
    	
    	try {
    		conn = util.getConnection();
    		UserDAO udao = new UserDAO(conn);
    		//User u = udao.readAgentById(id).get(0);
    		udao.delete(id);
    		
    		conn.commit();
    		System.out.println("Request completed!");
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	
	}


	public List<User> readAllTravelers() throws SQLException {
    	Connection conn = null;
    	List<User> travelers = new ArrayList<>();;
    	try {
    		conn = util.getConnection();
    		UserDAO udao = new UserDAO(conn);
    		travelers = udao.readAllTravelers();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return travelers;
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


	public void deleteTraveler(Integer id) throws SQLException {
	   	Connection conn = null;
    	
    	try {
    		conn = util.getConnection();
    		UserDAO udao = new UserDAO(conn);
    		udao.delete(id);
    		
    		conn.commit();
    		System.out.println("Request completed!");
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
		
	}


	public Route readRouteById(Integer routeId) throws SQLException {
	   	Connection conn = null;
    	List<Route> r = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		RouteDAO rdao = new RouteDAO(conn);
    		r = rdao.readRouteById(routeId);
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return r.get(0);
	}


	public Airplane readAirplanebyId(Integer id) throws SQLException {
		
	   	Connection conn = null;
    	List<Airplane> a = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		AirplaneDAO adao = new AirplaneDAO(conn);
    		a = adao.readById(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return a.get(0);
	}
		
	public List<Airplane> readAllAirplanes() throws SQLException {
    	Connection conn = null;
    	List<Airplane> airplanes = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		AirplaneDAO adao = new AirplaneDAO(conn);
    		airplanes = adao.readAll();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return airplanes;
	}


	public void addAirport(Airport a) throws SQLException {
    	Connection conn = null;
    	try {
    		conn = util.getConnection();
    		AirportDAO adao = new AirportDAO(conn);
    		
    	    System.out.println(a.getCity());
    	    System.out.println(a.getAirportCode());
    	
    	    adao.add(a);
    	    conn.commit();
    	    System.out.println("Airport added to database!");
    	    pres.menu();
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		conn.rollback();
    		System.out.println("Request not completed!");
    	} finally {
    		conn.close();
    	}
		
	}


	public List<Airport> readAllAirports() throws SQLException {
    	Connection conn = null;
    	List<Airport> airports = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		AirportDAO adao = new AirportDAO(conn);
    		airports = adao.readAll();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return airports;
	}


	public void updateAirport(Airport a) throws SQLException {
    	Connection conn = null;
    	try {
    		conn = util.getConnection();
    		AirportDAO adao = new AirportDAO(conn);
    		
    	    System.out.println(a.getCity());
    	    System.out.println(a.getAirportCode());

    	
    	    adao.update(a);
    	    conn.commit();
    	    System.out.println("Airport updated!");
    	    pres.menu();
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		conn.rollback();
    		System.out.println("Request not completed!");
    	} finally {
    		conn.close();
    	}
		
	}


	public Airport readAirportByCode(String airportCode) throws SQLException {
	   	Connection conn = null;
    	List<Airport> a = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		AirportDAO adao = new AirportDAO(conn);
    		a = adao.readById(airportCode);
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return a.get(0);
		
	}


	public void deleteAirport(String airportCode) throws SQLException {
	   	Connection conn = null;
    	Airport a = new Airport();
    	a.setAirportCode(airportCode);
    	try {
    		conn = util.getConnection();
    		AirportDAO adao = new AirportDAO(conn);
    		adao.delete(a);
    		
    		conn.commit();
    		System.out.println("Request completed!");
    		pres.menu();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
		
	}


	public List<Booking> readAllBookings() throws SQLException {
    	Connection conn = null;
    	List<Booking> bookings = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		BookingDAO bdao = new BookingDAO(conn);
    		bookings = bdao.readAll();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return bookings;
		
	}


	public Booking readBookingById(Integer id) throws SQLException {
	   	Connection conn = null;
    	List<Booking> b = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		BookingDAO bdao = new BookingDAO(conn);
    		b = bdao.readById(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return b.get(0);
		
	}


	public void overRideCancellation(Booking b) throws SQLException {
    	Connection conn = null;
    	try {
    		conn = util.getConnection();
    		BookingDAO bdao = new BookingDAO(conn);
 
           
    	
    	    bdao.update(b);
    	    conn.commit();
    	    System.out.println("Cancelled!");
    	    pres.menu();
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		conn.rollback();
    		System.out.println("Request not completed!");
    	} finally {
    		conn.close();
    	}
		
	}


	public List<Booking> readActiveBookings() throws SQLException {
    	Connection conn = null;
    	List<Booking> bookings = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		BookingDAO bdao = new BookingDAO(conn);
    		bookings = bdao.readAll();
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return bookings;
	}


	public void updateUser(User u) throws SQLException {
    	Connection conn = null;
    	try {
    		conn = util.getConnection();
    		UserDAO udao = new UserDAO(conn);
    		
    	    System.out.println();
    	    System.out.println();

    	
    	    udao.update(u);
    	    conn.commit();
    	    System.out.println("User updated!");
    	    pres.menu();
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    		conn.rollback();
    		System.out.println("Request not completed!");
    	} finally {
    		conn.close();
    	}
		
	}


	public User readTravelerById(Integer id) throws SQLException {
	   	Connection conn = null;
    	List<User> u = new ArrayList<>();
    	try {
    		conn = util.getConnection();
    		UserDAO udao = new UserDAO(conn);
    		u = udao.readTravelerById(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    		conn.rollback();
    	} finally {
    		conn.close();
    	}
    	return u.get(0);
	}


}
