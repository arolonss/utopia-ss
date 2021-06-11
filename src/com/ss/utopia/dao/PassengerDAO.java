package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ss.utopia.model.Passenger;


public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	public void add(Passenger p) throws SQLException, ClassNotFoundException {
		saveAndReturnPrimaryKey("insert into passenger (booking_id, given_name, family_name, dob, gender, address) values (?, ?, ?, ?, ?, ?)",
				new Object[] { p.getBookingNo(), p.getFirstName(), p.getLastName(), p.getDob(), p.getGender(), p.getAddress() });
	}
	
	public void update(Passenger p) throws SQLException, ClassNotFoundException {
		save("update passenger set booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? where id = ?",
				new Object[] { p.getFirstName(), p.getLastName(), p.getDob(), p.getGender(), p.getAddress(), p.getId() });
	}
	

	public void delete(Passenger p) throws SQLException, ClassNotFoundException {
		save("delete from passenger where id = ?", new Object[] { p.getId() } );
	}
	
	public List<Passenger> read() throws SQLException, ClassNotFoundException {
		return read("select * from passenger", null);
		
	}
	
	public List<Passenger> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from passenger where id = ?", new Object[] { id });
		
	}
	
	
	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		while(rs.next()) {
			Passenger p = new Passenger();
			
			p.setId(rs.getInt("id"));
			p.getBookingNo().setBookingNo(rs.getInt("booking_id"));
			p.setFirstName(rs.getString("given_name"));
			p.setLastName(rs.getString("family_name"));
			p.setDob(rs.getDate("dob"));
			p.setGender(rs.getString("gender"));
			p.setAddress(rs.getString("address"));
			
			passengers.add(p);
		}
		return passengers;
	}

}
