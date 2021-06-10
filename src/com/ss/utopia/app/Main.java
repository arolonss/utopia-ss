/**
 * 
 */
package com.ss.utopia.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ss.utopia.presentation.AgentPresentation;
import com.ss.utopia.presentation.Presentation;

/**
 * @author amanda
 *
 */
public class Main {
	static Scanner sc = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		
		Presentation pres = null;

		System.out.println("Welcome to Utopia Airlines Management System!");
		System.out.println("Which category user are you?");
		System.out.println("1) I am an agent");
		System.out.println("2) I am an admin");
		System.out.println("3) I am a traveler");
		try {
			Integer userInput = sc.nextInt();
			System.out.println(userInput);

			switch (userInput) {
			case 1:
				pres = new AgentPresentation();
				pres.menu();
				break;
			case 2:
				System.out.println("Go to admin pres");
				// pres = new AdminPresentation();
				// pres.menu();
				break;
			case 3:
				System.out.println("confirm member number and send to traveler pres");
				// getMemberNo();
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

	public static void exit() {
		System.out.println("Thank you for choosing Utopia Airlines. Goodbye!");
		sc.close();
		System.exit(0);
	}

}
