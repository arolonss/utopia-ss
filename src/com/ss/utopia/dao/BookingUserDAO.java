package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ss.utopia.model.BookingUser;


public class BookingUserDAO extends BaseDAO<BookingUser>{

	
	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	
	public void add(BookingUser bu) throws SQLException, ClassNotFoundException {
		save("insert into booking_user (booking_id, user_id) values (?, ?)",
				new Object[] { bu.getBookingId(), bu.getUserId(),  });
	}
	
	
	
	public void update(BookingUser bu) throws SQLException, ClassNotFoundException {
		save("update booking_user set booking_id = ?, user_id = ? where booking_id = ? and user_id = ?",
				new Object[] {  bu.getBookingId(), bu.getUserId() });
	}
	

	public void delete(BookingUser bu) throws SQLException, ClassNotFoundException {
		save("delete from booking_user where booking_id = ? and user_id = ?", new Object[] { bu.getBookingId(), bu.getUserId() } );
	}
	
	public List<BookingUser> readAll() throws SQLException, ClassNotFoundException {
		return read("select * from booking_user", null);
		
	}
	
	public List<BookingUser> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from booking_user where booking_id = ? and user_id = ?", new Object[] { id });
		
	}


	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> bookingUsers = new ArrayList<>();
		while(rs.next()) {
			BookingUser bu = new BookingUser();
			
			bu.getBookingId().setBookingNo(rs.getInt("booking_id"));
			bu.getUserId().setId(rs.getInt("user_id"));
			
		    bookingUsers.add(bu);
		}
		return bookingUsers;
	}

}
