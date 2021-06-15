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

	

	public void update(Integer id) throws SQLException, ClassNotFoundException {
		//not done yet
		User u = admin.readUserById(id);
		
		
		System.out.println("You are updating info for " + " " + u.toString());
		u.setId(id);
		System.out.println(u.getId());
		
        
		String fName = u.getFirstName();
		String lName = u.getLastName();
		String username = u.getUsername();
		String email = u.getEmail();
		
		String phone = u.getEmail();

		sc.useDelimiter("\\t");
		while (true) {
			// First name
			System.out.println("Update first Name? y/n");
			String ufn = sc.nextLine();
			if (ufn.equalsIgnoreCase("y")) {
				u.setFirstName(updateFirstName());
			    
			}
			else if (ufn.equalsIgnoreCase("n")){
				u.setFirstName(u.getFirstName());
			} else {
				System.out.println("Please select y to update or n to keep current info.");
			
			}
			
			// last name
			System.out.println("Update last Name? y/n");
			String uln = sc.nextLine();
			if (uln.equalsIgnoreCase("y")) {
				u.setLastName(updateLastName());
			    
			}
			else if (uln.equalsIgnoreCase("n")){
				u.setLastName(u.getLastName());
			} else {
				System.out.println("Please select y to update or n to keep current info.");
			}
			
			// username
			System.out.println("Update username? y/n");
			String uu = sc.nextLine();
			if (uu.equalsIgnoreCase("y")) {
				u.setUsername(updateUsername());
			    
			}
			else if (uu.equalsIgnoreCase("n")){
				u.setUsername(u.getUsername());
			} else {
				System.out.println("Please select y to update or n to keep current info.");
			}

			// email
			System.out.println("Update email? y/n");
			String ue = sc.nextLine();
			if (ue.equalsIgnoreCase("y")) {
				u.setEmail(updateEmail());
			    
			}
			else if (ue.equalsIgnoreCase("n")){
				u.setEmail(u.getEmail());
			} else {
				System.out.println("Please select y to update or n to keep current info.");
			}

			// phone
			System.out.println("Update phone? y/n");
			String up = sc.nextLine();
			if (up.equalsIgnoreCase("y")) {
				u.setPhone(updatePhone());
			    
			}
			else if (up.equalsIgnoreCase("n")){
				u.setPhone(u.getPhone());
			} else {
				System.out.println("Please select y to update or n to keep current info.");
			}
			
			break;
		}

		//ur.setId(role);
		
//		u.setFirstName(fName);
//		u.setLastName(lName);
//		u.setUsername(username);
//		u.setEmail(email);
		//u.setRole(u.getRole());
        u.setPassword(u.getPassword());
//		u.setPhone(phone);
        System.out.println(u);
		admin.updateUser(u);

	}

	
	public void readAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}


	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	
	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		

	}

	
	public void add() throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub

	}
	
	public List<User> readAllAgents() throws SQLException {
		return admin.readAllAgents();
	}

	public User readAgentById(Integer id) throws SQLException {
		return admin.readAgentById(id);
		
	}

	
	public void update(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public void deleteAgent(Integer id) throws SQLException, ClassNotFoundException {
		admin.deleteAgent(id);
    }

	public List<User> readAllTravelers() throws SQLException {
		return admin.readAllTravelers();
		
	}

	
	public void delete(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public void deleteTraveler(Integer id) throws SQLException {
		admin.deleteTraveler(id);
		
	}

	private String updateFirstName() {
		System.out.println("First Name:");
		String fName = sc.nextLine();
		return fName;
		
	}

	private String updateLastName() {
		System.out.println("Last Name:");
		String lName = sc.nextLine();
		return lName;
		
	}
	
	private String updateUsername() {
		System.out.println("Username:");
		String username = sc.nextLine();
		return username;
		
	}
	
	private String updateEmail() {
		System.out.println("Email:");
		String email = sc.nextLine();
		return email;
		
	}
	private String updatePhone() {
		System.out.println("Phone:");
		String phone = sc.nextLine();
		return phone;
		
	}


	public User readTravelerById(Integer id) throws SQLException {
		return admin.readTravelerById(id);
	}
}
