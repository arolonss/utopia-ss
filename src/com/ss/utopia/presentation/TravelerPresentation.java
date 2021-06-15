package com.ss.utopia.presentation;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.app.Main;
import com.ss.utopia.model.Booking;
import com.ss.utopia.model.Flight;
import com.ss.utopia.model.Route;
import com.ss.utopia.service.TravelerService;

public class TravelerPresentation extends Presentation {
	static Scanner sc = new Scanner(System.in);
	static TravelerService ts = new TravelerService();
	public TravelerPresentation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void menu() throws Exception {
		
		
		System.out.println("1) Book a ticket");
		System.out.println("2) Cancel an upcoming trip ");
		System.out.println("3) Quit to previous ");
		
		Integer opt = sc.nextInt();
		
		switch(opt) {
		case 1:
			bookTicket();
			break;
		case 2:
			cancelTrip();
			break;
		case 3:
			Main.main(null);
			break;
		default:
		}
		
	}

	private void cancelTrip() {
		//list booked flights from this user, user chooses flight to cancel and is refunded.
		System.out.println("Book ticket first");
		
	}

	private void bookTicket() throws Exception {
		Booking booking = new Booking();
		Flight flight = new Flight();
//		Route route = new Route();
		
		System.out.println("Choose the flight number you want to book a ticket for:");
		
		ts.readAllFlights().forEach(f -> System.out.println(f.toString()));
		Integer id = sc.nextInt();
		/*list flights, user chooses flight and then chooses seat 
		chooseSeat(flight), and last option, quit to previous.
		 chooseSeat(flight) will have view, flight details and seats by clas, last option, quit to cancel, go to menu()
		*/
		
		flight = ts.findFlightById(id);
		System.out.println("How many seats would you like to reserve on this flight?");
//		System.out.println("Hit 'q' to quit to previous");
		Integer seats = sc.nextInt();
		
		flight.setReservedSeats(flight.getReservedSeats() + seats);
		booking.setIs_active(1);
		booking.setConfCode("UB" + (int) (Math.random() * 9999 + 1));
		ts.createBooking(booking, flight);
		
//		if (flight.getReservedSeats() + seats > flight.getAirplaneId().getTypeId().getMaxCap()) {
//			System.out.println("There are not enough available seats on this flight. Please choose a different flight.");
//		    bookTicket();
//		} else if (flight.getReservedSeats() + seats < flight.getAirplaneId().getTypeId().getMaxCap()) {
//			flight.setReservedSeats(flight.getReservedSeats() + seats);
//			booking.setIs_active(1);
//			booking.setConfCode("UB" + (int) (Math.random() * 9999 + 1));
//			ts.createBooking(booking, flight);
//		}
			
		
		
		
		
		menu();
	}


	

	

}
