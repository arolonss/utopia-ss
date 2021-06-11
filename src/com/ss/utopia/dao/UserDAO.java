package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.Passenger;
import com.ss.utopia.model.User;

public class UserDAO extends BaseDAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	
	public void add(User u) throws SQLException, ClassNotFoundException {
		saveAndReturnPrimaryKey("insert into user (role_id, given_name, family_name, username, email, password, phone) values (?, ?, ?, ?, ?, ?)",
				new Object[] { u.getRole(), u.getFirstName(), u.getLastName(), u.getUsername(), u.getEmail(), u.getPassword(), u.getPhone() });
	}
	
	public void update(User u) throws SQLException, ClassNotFoundException {
		save("update user set role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ? phone = ? where id = ?",
				new Object[] { u.getRole(), u.getFirstName(), u.getLastName(), u.getUsername(), u.getEmail(), u.getPassword(), u.getPhone(), u.getId() });
	}
	

	public void delete(User u) throws SQLException, ClassNotFoundException {
		save("delete from user where id = ?", new Object[] { u.getId() } );
	}
	
	public List<User> read() throws SQLException, ClassNotFoundException {
		return read("select * from user", null);
		
	}
	
	public List<User> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from user where id = ?", new Object[] { id });
		
	}


	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();
		while(rs.next()) {
			User u = new User();
			
			u.setId(rs.getInt("id"));
			u.getRole().setId(rs.getInt("role_id"));
			u.setFirstName(rs.getString("given_name"));
			u.setLastName(rs.getString("family_name"));
			u.setUsername(rs.getString("username"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setPhone(rs.getString("phone"));
			
			users.add(u);
		}
		return users;
	}
}
