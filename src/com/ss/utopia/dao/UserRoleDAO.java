package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.Airplane;
import com.ss.utopia.model.Flight;
import com.ss.utopia.model.Route;
import com.ss.utopia.model.UserRole;

public class UserRoleDAO extends BaseDAO<UserRole>{

	public UserRoleDAO(Connection conn)  {
		super(conn);
	}

	public void add(UserRole userRole) throws SQLException, ClassNotFoundException {
		saveAndReturnPrimaryKey("insert into user_role (id, name) (?, ?)",
				new Object[] { userRole.getId(), userRole.getRoleTitle() });
		
	}

	public void update(UserRole userRole) throws SQLException, ClassNotFoundException {
		save("update user_role set name = ? where id = ?", new Object[] { userRole.getId()} );
		
	}

	
	public void delete(UserRole userRole) throws SQLException, ClassNotFoundException {
		save("delete from user_role where id = ?", new Object[] { userRole.getId() } );
		
	}

	
	public List<UserRole> readAll() throws SQLException, ClassNotFoundException {
		return read("select * from user_role", null);
	}

	
	public List<UserRole> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from user_role where id = ?", new Object[] { id });
	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> userRoles = new ArrayList<>();
		while(rs.next()) {
			UserRole ur = new UserRole();
			
			
			ur.setId(rs.getInt("id"));

			ur.setRoleTitle(rs.getString("name"));
			
			userRoles.add(ur);
		}
		return userRoles;
	}

}
