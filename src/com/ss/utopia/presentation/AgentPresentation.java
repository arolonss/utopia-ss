package com.ss.utopia.presentation;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ss.utopia.app.Main;

public class AgentPresentation extends Presentation {
	static Scanner sc = new Scanner(System.in);

	public AgentPresentation() {
		
	}

	@Override
	public void menu() throws SQLException, ClassNotFoundException, InputMismatchException {
		System.out.println("1) Enter flights you manage");
		System.out.println("2) Quit to previous");
		try {
			int userInput = sc.nextInt();
			System.out.println(userInput);

			switch (userInput) {
			case 1:
				listFlights();
				break;
			case 2:
				Main.main(null);
				break;
			default:
				System.out.println("Invalid selection. Try Again!");
				menu();
				break;

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Invalid input. Please use an integer.");
			menu();
		}
		Main.exit();
	}

	public void listFlights() throws ClassNotFoundException, SQLException {
		System.out.println("List of 10 flights will go here");
		System.out.println("Select a flight to manage: ");
		// make array of flights and loop through the to print
		// take input, send selection to

		Integer flightChoice = sc.nextInt();
		flightOptions(flightChoice);
	}

	public void flightOptions(Object flightChoice) throws ClassNotFoundException, SQLException {
		//maybe I don't need this method and it can go in listFlights
		System.out.println("1) View more details about this flight");
		System.out.println("2) Update details of this flight");
		System.out.println("3) Add seats to flight");
		System.out.println("4) Quit to previous");

		try {
			int userInput = sc.nextInt();
			System.out.println(userInput);

			switch (userInput) {
			case 1:
				flightDetails(flightChoice);
				break;
			case 2:
				updateFlightDetails(flightChoice);
				break;

			case 3:
				addSeatsToFlight(flightChoice);
				break;

			default:
				System.out.println("Invalid selection. Try Again!");
				menu();
				break;

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Invalid input. Please use an integer.");
			menu();
		}
		Main.exit();
	}

	public void flightDetails(Object flight) {
		System.out.println("You have chosen to view flight with flight id x and departure airport y and arrival airport z");
		System.out.println("departure airport: arrival airport:");
		System.out.println("Departure Date: Departure Time:");
		System.out.println("Arrival Date: Arrival Time: ");
		
		
		System.out.println("Available seats by class:");
		// loop  through seat classes?
		System.out.println("List seats by First, Business, Economy");
		//Take input
		System.out.println("Return to previous menu");
//		switch(seatClass) {
//		
//		case 1:
//			
//			break;
//		case 2:
//			break;
//		case 3:
//			break;
//		case 4:
//			flightOptions(flight);
//		default:
//			
//		}
	
	}

	public void updateFlightDetails(Object flight) {
		System.out.println("let user update Flight details");
	}
	
	public void addSeatsToFlight(Object seats) {
		System.out.println("let user add seats to flight");
	}
}
