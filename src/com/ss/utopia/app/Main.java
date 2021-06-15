/**
 * 
 */
package com.ss.utopia.app;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ss.utopia.presentation.AgentPresentation;
import com.ss.utopia.presentation.Presentation;
import com.ss.utopia.presentation.TravelerPresentation;
import com.ss.utopia.presentation.admin.AdminPresentation;
import com.ss.utopia.service.TravelerService;

/**
 * @author amanda
 *
 */
public class Main {
	static Scanner sc = new Scanner(System.in);
	static Presentation pres = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		System.out.println("Welcome to Utopia Airlines Management System!");
		System.out.println("Which category user are you?");
		System.out.println("1) I am an agent (Coming Soon!)");
		System.out.println("2) I am an admin");
		System.out.println("3) I am a traveler");
		try {
			Integer userInput = Integer.parseInt(sc.nextLine());
			System.out.println(userInput);

			switch (userInput) {
			case 1:
				System.out.println("Under construction. Please check back soon!");
//				pres = new AgentPresentation();
//				pres.menu();
				main(null);
				break;
			case 2:
				pres = new AdminPresentation();
				pres.menu();
				break;
			case 3:
				verifyMembership();
				pres = new TravelerPresentation();
				pres.menu();
				break;
			default:

				System.out.println("Invalid selection. Try Again!");
				main(null);
				break;
			}

		} catch (ClassNotFoundException e) {

			System.out.println("Invalid input. Please use an integer.");

			main(null);
			exit();
		}
	}

	private static void verifyMembership() throws Exception {
		TravelerService ts = new TravelerService();
		String username;
		System.out.println("Enter your username: ");

		sc.useDelimiter("\\t");
		while (true) {
			username = sc.nextLine();
			System.out.println("Verifying username in database...");
			
			break;
		}
		if (ts.verifyMembership(username)) {
			pres = new TravelerPresentation();
			pres.menu();
		} else {
			System.out.println("invalid username. Try again later.");
			main(null);

		}

	}

	public static void exit() {
		System.out.println("Thank you for choosing Utopia Airlines. Goodbye!");
		sc.close();
		System.exit(0);
	}

}
