package com.ss.utopia.presentation.admin;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.ss.utopia.model.Agent;
import com.ss.utopia.model.User;
import com.ss.utopia.model.UserRole;
import com.ss.utopia.service.AdminService;



public class AdminAgent implements AdminCrud<Agent>{

	private AdminService admin;
	static Scanner sc = new Scanner(System.in);

	public AdminAgent(AdminService admin) {
		super();
		this.admin = admin;
	}

	@Override
	public void add() throws SQLException, ClassNotFoundException, ParseException {
		Agent u = new Agent();
		UserRole ur = new UserRole();
		
		Integer userRole = 1;
	    String fName = null;
	    String lName = null;
	    String username = null;
	    String email = null;
	    String password = null;
	    String phone = null;

		try {
			sc.useDelimiter("\\t");
			while (true) {
				System.out.println("Select a role for this user:");
				admin.readAllUserRoles().forEach(r -> System.out.println());
				userRole = Integer.parseInt(sc.nextLine());
				ur.setId(userRole);
				System.out.println("User First Name:");
				fName = sc.nextLine();
				
				System.out.println("User Last Name");
				lName = sc.nextLine();
				

				System.out.println("Username:");
				
				username = sc.nextLine();
				
				
				System.out.println("Password:");
				password = sc.nextLine();
				
				System.out.println("Email:");
				email = sc.nextLine();
				System.out.println("Phone:");
				phone = sc.nextLine();
				

	
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	    u.setRole(ur);
		u.setFirstName(fName);
		u.setLastName(lName);
		u.setUsername(username);
		u.setEmail(email);
		u.setPassword(password);
		u.setPhone(phone);

		admin.addUser(u);
		
	}

	@Override
	public void update(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		
		
	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
