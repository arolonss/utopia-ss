package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.model.Route;
import com.ss.utopia.model.User;

public class TravelerService {

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

	public void createBooking() {
		
		
	}
}
