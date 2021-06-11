package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.Booking;

public class BookingDAO extends BaseDAO<Booking>{


	public BookingDAO(Connection conn) {
		super(conn);
	}

	
	public void add(Booking b) throws SQLException, ClassNotFoundException {
		saveAndReturnPrimaryKey("insert into booking (is_active, confirmation_code) values (?, ?)",
				new Object[] { b.isIs_active(), b.getConfCode() });
	}
	
	public void update(Booking b) throws SQLException, ClassNotFoundException {
		save("update booking set is_active = ?, confirmation_code = ? where id = ?",
				new Object[] { b.getBookingNo() });
	}
	

	public void delete(Booking b) throws SQLException, ClassNotFoundException {
		save("delete from booking where id = ?", new Object[] { b.getBookingNo() } );
	}
	
	public List<Booking> readAll() throws SQLException, ClassNotFoundException {
		return read("select * from booking", null);
		
	}
	
	public List<Booking> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from booking where id = ?", new Object[] { id });
		
	}


	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> bookings = new ArrayList<>();
		while(rs.next()) {
			Booking b = new Booking();
			
			b.setBookingNo(rs.getInt("id"));
			b.setIs_active(rs.getBoolean("is_active")); 
			
			bookings.add(b);
		}
		return bookings;
	}
}
