package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest>{


	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	
	public void add(BookingGuest bg) throws SQLException, ClassNotFoundException {
		save("insert into booking_guest (booking_id, contact_email, contact_phone) values (?, ?, ?)",
				new Object[] { bg.getBookingId(), bg.getEmail(), bg.getPhone()  });
	}
	
	
	public void update(BookingGuest bg) throws SQLException, ClassNotFoundException {
		save("update booking_guest set contact_email = ?, contact_phone = ? where booking_id = ?",
				new Object[] {  bg.getEmail(), bg.getPhone(), bg.getBookingId().getBookingNo() });
	}
	

	public void delete(BookingGuest bg) throws SQLException, ClassNotFoundException {
		save("delete from booking_guest where booking_id = ?", new Object[] { bg.getBookingId().getBookingNo() } );
	}
	
	public List<BookingGuest> readAll() throws SQLException, ClassNotFoundException {
		return read("select * from booking_guest", null);
		
	}
	
	public List<BookingGuest> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from booking_guest where booking_id = ?", new Object[] { id });
		
	}


	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> bookingGuests = new ArrayList<>();
		while(rs.next()) {
			BookingGuest bg = new BookingGuest();
			
			bg.getBookingId().setBookingNo(rs.getInt("id"));
			bg.setEmail(rs.getString("contact_email"));
			bg.setPhone(rs.getString("contact_phone"));
			
		    bookingGuests.add(bg);
		}
		return bookingGuests;
	}
}
