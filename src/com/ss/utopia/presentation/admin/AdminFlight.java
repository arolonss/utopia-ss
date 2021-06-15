package com.ss.utopia.presentation.admin;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.model.Airplane;
import com.ss.utopia.model.Airport;
import com.ss.utopia.model.Flight;
import com.ss.utopia.model.Route;
import com.ss.utopia.service.AdminService;
import com.sun.tools.javac.Main;

public class AdminFlight implements AdminCrud<Flight> {

	private AdminService admin;
	static Scanner sc = new Scanner(System.in);

	public AdminFlight(AdminService admin) {
		super();
		this.admin = admin;
	}

	
	public void add() throws Exception {
		Flight f = new Flight();
	    
		
		
		//Integer route = null;
		Integer airplaneId = null;
		//String depTime;
		String origin = null;
		String dest = null;
		String dt;
        Date dateFormat = null;
		Integer reservedSeats = null;
		Float seatPrice = null;
		try {
			sc.useDelimiter("\\t");
			while (true) {
//				System.out.println("Enter a flight id:");
//				id = Integer.parseInt(sc.nextLine());
				System.out.println("Select an origin airport by its 3-char code:");
				List<Airport> oAirports = admin.readAllAirports();
				oAirports.forEach(a -> System.out.println(a.getAirportCode() + " " + a.getCity())); //.getId() +" " + r.getOrgId() + " -> " + r.getDestId()));
				System.out.println(oAirports);
				origin = sc.nextLine();
				
				System.out.println("Select a destination airport by its 3-char code:");
				List<Airport> dAirports = admin.readAllAirports();
				dAirports.forEach(a -> System.out.println(a.getAirportCode() + " " + a.getCity())); //.getId() +" " + r.getOrgId() + " -> " + r.getDestId()));
				System.out.println(dAirports);
				dest = sc.nextLine();
				
				System.out.println("Select aircraft by its id");
				admin.readAllAirplanes().forEach(a -> System.out.println(a.toString()));
				airplaneId = Integer.parseInt(sc.nextLine());
				//airplane = admin.readAirplanebyId(airplaneId);
				// setId(airplaneId);

				System.out.println("Enter a departure time in this format yyyy-mm-dd hh:mm");
				
				dt = sc.nextLine();
				dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm").parse(dt);
				
				System.out.println(dateFormat);
				
				
				System.out.println();

				System.out.println("Enter reserved seats: ");
				reservedSeats = Integer.parseInt(sc.nextLine());

				System.out.println("Enter seat price: ");
				seatPrice = Float.parseFloat(sc.nextLine());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Timestamp dTime = new java.sql.Timestamp(dateFormat.getTime());
		
		Integer id = admin.readAllFlights().size() + 1;
		Route route = new Route();
		route.setOrgId(admin.readAirportByCode(origin));
		route.setDestId(admin.readAirportByCode(dest));
        Airplane a = new Airplane();
        a.setId(airplaneId);

		admin.addFlight(id, route, a, dTime, reservedSeats, seatPrice);

	}
	
	public void update(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	
	public List<Flight> readAll() throws ClassNotFoundException, SQLException {
		return admin.readAllFlights();

	}


	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	

	public void delete(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}


	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}


	public void add(Integer role) throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		
	}


	public void update(Integer id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}



}
