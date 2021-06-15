package com.ss.utopia.presentation.admin;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.app.Main;
import com.ss.utopia.model.Agent;
import com.ss.utopia.model.Booking;
import com.ss.utopia.model.User;
import com.ss.utopia.presentation.Presentation;
import com.ss.utopia.service.AdminService;

public class AdminPresentation extends Presentation {
	static Scanner sc = new Scanner(System.in);
	static AdminService admin = new AdminService();

	public AdminPresentation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void menu() throws Exception {

		System.out.println("Welcome Admin!");
		System.out.println("What are you working on today?");
		System.out.println("1) Flight");
		System.out.println("2) Seats");
		System.out.println("3) Tickets and passengers");
		System.out.println("4) Airports");
		System.out.println("5) Travelers");
		System.out.println("6) Agents");
		System.out.println("7) Over-ride trip cancellation");
		System.out.println("8) Quit to previous");

		try {
			Integer opt = sc.nextInt();
			System.out.println(opt);

			switch (opt)

			{
			case 1:
				flightOptions();
				break;
			case 2:
				seatOptions();
				break;
			case 3:
				ticketAndPassengerOptions();
				break;
			case 4:
				airportOptions();
				break;
			case 5:
				travelerOptions();
				break;
			case 6:
				agentOptions();
				break;
			case 7:
				overRideCancellation();
				break;
			case 8:
				Main.main(null);
				break;
			default:
				System.out.println("Invalid selection. Try again.");
				menu();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!"); // fix this later (parseInt?)
			menu();
		}

	}

	private void airportOptions() throws Exception {

		AdminAirport aa = new AdminAirport(admin);
		Integer id;
		System.out.println("1) Add an airport");
		System.out.println("2) View airports");
		System.out.println("3) Update an airport");
		System.out.println("4) Delete an airport");
		System.out.println("5) Quit to previous");
		try {

			Integer opt = sc.nextInt();
			System.out.println(opt);

			switch (opt)

			{
			case 1:
				aa.add();
				break;
			case 2:
				System.out.println(admin);
				System.out.println("View airports");
				aa.readAll().forEach(a -> System.out.println(a.toString()));
				airportOptions();
				break;

			case 3:
				aa.readAll().forEach(a -> System.out.println(a.toString()));

				System.out.println("Choose airport to Update by id");

				String acode = sc.nextLine();

				aa.update(acode);

				break;

			case 4:
				aa.readAll().forEach(a -> System.out.println(a.toString()));
				System.out.println("Select an airport to delete");
				String code = sc.nextLine();
				System.out.println(code);
				aa.delete(code);

				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				airportOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! Please try again");
			airportOptions();
		}
		sc.close();

	}

	private void overRideCancellation() throws Exception {
		System.out.println("Select a booking to override cancel");
		List<Booking> activeBookings = admin.readActiveBookings();
		activeBookings
				.forEach(b -> System.out.println(b.getBookingNo() + " " + b.getIs_active() + " " + b.getConfCode()));
		Integer selection = sc.nextInt();
		Booking overrideBooking = admin.readBookingById(selection);

		overrideBooking.setIs_active(0);
		overrideBooking.setConfCode("UTP" + (int) (Math.random() * 9999 + 1));
		admin.overRideCancellation(overrideBooking);
		menu();
	}

	private void agentOptions() throws Exception {

		AdminUser au = new AdminUser(admin);
		Integer id;
		System.out.println("1) Add an agent");
		System.out.println("2) View agents");
		System.out.println("3) Update an agent");
		System.out.println("4) Delete an agent");
		System.out.println("5) Quit to previous");
		try {

			Integer opt = sc.nextInt();
			System.out.println(opt);

			switch (opt)

			{
			case 1:
				au.add(1);
				break;
			case 2:
				
				System.out.println("View agents");
				au.readAllAgents().forEach(a -> System.out.println(a.toString()));
				agentOptions();
				break;

			case 3:
				au.readAllAgents().forEach(a -> System.out.println(a.toString()));

				System.out.println("Choose agent to Update by id");

				id = sc.nextInt();

				System.out.println(au.readAgentById(id));

				au.update(id);

				break;

			case 4:
				au.readAllAgents().forEach(a -> System.out.println(a.toString()));
				System.out.println("Select a agent to delete");
				id = Integer.parseInt(sc.nextLine());
				System.out.println(id);
				au.deleteAgent(id);

				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				agentOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			agentOptions();
		}
		sc.close();

	}

	private void travelerOptions() throws Exception {

		AdminUser au = new AdminUser(admin);
		Integer id;
		System.out.println("1) Add a traveler");
		System.out.println("2) View travelers");
		System.out.println("3) Update a traveler");
		System.out.println("4) Delete a traveler");
		System.out.println("5) Quit to previous");
		try {

			Integer opt = sc.nextInt();
			System.out.println(opt);

			switch (opt)

			{
			case 1:
				au.add(3);
				break;
			case 2:
				System.out.println(admin);
				System.out.println("View travelers");
				au.readAllTravelers();

				au.readAllTravelers().forEach(a -> System.out.println(a.toString()));
				travelerOptions();

				break;

			case 3:
				au.readAllTravelers().forEach(a -> System.out.println(a.toString()));

				System.out.println("Choose traveler to Update by id");

				id = sc.nextInt();

				System.out.println(au.readTravelerById(id));

				au.update(id);
				break;

			case 4:
				au.readAllTravelers().forEach(t -> System.out.println(t.toString()));
				System.out.println("Select a traveler to delete");
				id = Integer.parseInt(sc.nextLine());
				System.out.println(id);
				au.deleteTraveler(id);

				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				travelerOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			travelerOptions();
		}
		sc.close();

	}

	// not done yet
	private void ticketAndPassengerOptions() {
//		AdminPassenger ap = new AdminPassenger(admin);
//		Integer id;
//		System.out.println("1) Add an agent");
//		System.out.println("2) View agents");
//		System.out.println("3) Update an agent");
//		System.out.println("4) Delete an agent");
//		System.out.println("5) Quit to previous");
//		try {
//
//			Integer opt = Integer.parseInt(sc.nextLine());
//			System.out.println(opt);
//
//			switch (opt)
//
//			{
//			case 1:
//				ap.add(1);
//				break;
//			case 2:
//				System.out.println(admin);
//				System.out.println("View passengers");
//				ap.readAll().forEach(p -> System.out.println(p.toString()));
//				ticketAndPassengerOptions();
//				break;
//
//			case 3:
//				ap.readAll().forEach(a -> System.out.println(a.toString()));
//				
//				System.out.println("Choose agent to Update by id");
//                
//				id = Integer.parseInt(sc.nextLine());
//               
//                
//				System.out.println(ap.readById(id));
//                
//				ap.update(id);
//				
//                //agentOptions();
//				break;
//
//			case 4:
//				ap.readAll().forEach(p -> System.out.println(a.toString()));
//				System.out.println("Select a agent to delete");
//				id = Integer.parseInt(sc.nextLine());
//				System.out.println(id);
//				ap.delete(id);
//
//				break;
//			case 5:
//				menu();
//				break;
//			default:
//				System.out.println("invalid input");
//				ticketAndPassengerOptions();
//			}
//		} catch (InputMismatchException e) {
//			System.out.println("You must select an integer!");
//			ticketAndPassengerOptions();
//		}
//		sc.close();

	}

	/// not done yet
	private void seatOptions() {
//		AdminUser au = new AdminUser(admin);
//		Integer id;
//		System.out.println("1) Add an agent");
//		System.out.println("2) View agents");
//		System.out.println("3) Update an agent");
//		System.out.println("4) Delete an agent");
//		System.out.println("5) Quit to previous");
//		try {
//
//			Integer opt = Integer.parseInt(sc.nextLine());
//			System.out.println(opt);
//
//			switch (opt)
//
//			{
//			case 1:
//				au.add(1);
//				break;
//			case 2:
//				System.out.println(admin);
//				System.out.println("View agents");
//				au.readAllAgents().forEach(a -> System.out.println(a.toString()));
//				agentOptions();
//				break;
//
//			case 3:
//				au.readAllAgents().forEach(a -> System.out.println(a.toString()));
//				
//				System.out.println("Choose agent to Update by id");
//                
//				id = Integer.parseInt(sc.nextLine());
//               
//                
//				System.out.println(au.readAgentById(id));
//                
//				au.update(id);
//				
//                //agentOptions();
//				break;
//
//			case 4:
//				au.readAllAgents().forEach(a -> System.out.println(a.toString()));
//				System.out.println("Select a agent to delete");
//				id = Integer.parseInt(sc.nextLine());
//				System.out.println(id);
//				au.deleteAgent(id);
//
//				break;
//			case 5:
//				menu();
//				break;
//			default:
//				System.out.println("invalid input");
//				agentOptions();
//			}
//		} catch (InputMismatchException e) {
//			System.out.println("You must select an integer!");
//			agentOptions();
//		}
//		sc.close();
//		
	}

	private void flightOptions() throws Exception {

		AdminFlight af = new AdminFlight(admin);
		Integer id;
		System.out.println("1) Add a flight");
		System.out.println("2) View flights");
		System.out.println("3) Update a flight");
		System.out.println("4) Delete a book");
		System.out.println("5) Quit to previous");
		try {

			Integer opt = sc.nextInt();
			System.out.println(opt);

			switch (opt)

			{
			case 1:
				af.add();
				break;
			case 2:
				System.out.println(admin);
				System.out.println("View flights");
				af.readAll().forEach(f -> System.out.println(f));
				flightOptions();
				break;

			case 3:
				af.readAll();
				System.out.println("choose flight to Update");
			case 4:
				af.readAll(); // .forEach(f -> System.out.println(f.toString()));
				System.out.println("Select a flight to delete");
				id = Integer.parseInt(sc.nextLine());
				System.out.println(id);
				af.delete(id);

				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				flightOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			flightOptions();
		}
		sc.close();

	}

}
