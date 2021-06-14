package com.ss.utopia.presentation.admin;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.model.Airport;
import com.ss.utopia.service.AdminService;

public class AdminAirport implements AdminCrud<Airport> {

	private AdminService admin;
	static Scanner sc = new Scanner(System.in);
	private AdminPresentation ap = new AdminPresentation();

	public AdminAirport(AdminService admin) {
		super();
		this.admin = admin;
	}

	public void add() throws SQLException, ClassNotFoundException, ParseException {

		Airport a = new Airport();

		System.out.println("Add an airport:");
		String city;
		String airportCode;
		sc.useDelimiter("\\t");
		try {
			while (true) {

				System.out.println("Enter 3 character IATA code:");
				airportCode = sc.nextLine();
				System.out.println("City");
				city = sc.nextLine();

				break;
			}
			a.setCity(city);
			a.setAirportCode(airportCode);
			admin.addAirport(a);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("There was a problem with your request! Please try again.");
			add();
		}
	}


	public void update(Object obj) throws SQLException, ClassNotFoundException, ParseException {
		Airport a = new Airport();

		System.out.println("Edit an airport:");
		String city;
		String airportCode;
		sc.useDelimiter("\\t");
		try {
			while (true) {

				System.out.println("Enter 3 character IATA code:");
				airportCode = sc.nextLine();
				System.out.println("City");
				city = sc.nextLine();

				break;
			}
			a.setCity(city);
			a.setAirportCode(airportCode);
			admin.updateAirport(a);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("There was a problem with your request! Please try again.");
			ap.menu();
		} 

	}

	
	public Airport readById(String airportCode) throws ClassNotFoundException, SQLException {
		return admin.readAirportByCode(airportCode);

	}


	public void delete(String airportCode) throws SQLException, ClassNotFoundException {
		admin.deleteAirport(airportCode);

	}

	
	public void update(Integer id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	public List<Airport> readAll() throws SQLException {
		return admin.readAllAirports();
	}

}
