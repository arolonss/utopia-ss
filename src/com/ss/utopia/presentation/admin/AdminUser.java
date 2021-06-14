package com.ss.utopia.presentation.admin;

import java.sql.SQLException;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.model.User;
import com.ss.utopia.model.UserRole;
import com.ss.utopia.service.AdminService;

public class AdminUser implements AdminCrud<User> {

	private AdminService admin;
	static Scanner sc = new Scanner(System.in);

	public AdminUser(AdminService admin) {
		super();
		this.admin = admin;
	}

	@Override
	public void add(Integer role) throws SQLException, ClassNotFoundException, ParseException {
		User u = new User();
		UserRole ur = new UserRole();

		String fName = null;
		String lName = null;
		String username = null;
		String email = null;
		String password = null;
		String phone = null;

		try {
			sc.useDelimiter("\\t");
			while (true) {
//				System.out.println("Select a role for this user:");
//				admin.readAllUserRoles().forEach(r -> System.out.println());
//				userRole = Integer.parseInt(sc.nextLine());
//				ur.setId(userRole);
				System.out.println("First Name:");
				fName = sc.nextLine();

				System.out.println("Last Name");
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

		ur.setId(role);
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
	public void update(Integer id) throws SQLException, ClassNotFoundException {
		//not done yet
		User u = admin.readUserById(id);
		System.out.println(id);
		
		System.out.println(u.toString());
		u.setId(id);
		System.out.println(u.getId());
		UserRole ur = new UserRole();
        
		String fName = null;
		String lName = null;
		String username = null;
		String email = null;
		String password = null;
		String phone = null;

		sc.useDelimiter("\\t");
		while (true) {
			System.out.println("First Name:");
			fName = sc.nextLine();

			System.out.println("Last Name");
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

		//ur.setId(role);
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
	public void readAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		

	}

	@Override
	public void add() throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub

	}
	
	public List<User> readAllAgents() throws SQLException {
		return admin.readAllAgents();
	}

	public User readAgentById(Integer id) throws SQLException {
		return admin.readAgentById(id);
		
	}

	@Override
	public void update(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public void deleteAgent(Integer id) throws SQLException, ClassNotFoundException {
		admin.deleteAgent(id);
    }

	public List<User> readAllTravelers() throws SQLException {
		return admin.readAllTravelers();
		
	}

	@Override
	public void delete(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public void deleteTraveler(Integer id) throws SQLException {
		admin.deleteTraveler(id);
		
	}


}
