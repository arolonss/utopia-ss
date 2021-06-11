package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.FlightBookings;
import com.ss.utopia.model.User;

public class FlightBookingsDAO extends BaseDAO<FlightBookings>{

	public FlightBookingsDAO(Connection conn) {
		super(conn);
	}

	
	public void add(FlightBookings fb) throws SQLException, ClassNotFoundException {
		save("insert into flight_bookings (flight_id, booking_id) values (?, ?)",
				new Object[] { fb.getFlightId(), fb.getBookingId() });
	}
	
	
	// ?????
	public void update(FlightBookings fb) throws SQLException, ClassNotFoundException {
		save("update flight_bookings set flight_id = ?, booking_id = ? where flight_id = ? and booking_id = ?",
				new Object[] { fb.getFlightId(), fb.getBookingId() });
	}
	

	public void delete(FlightBookings fb) throws SQLException, ClassNotFoundException {
		save("delete from user where flight_id = ? and booking_id = ?", new Object[] { fb.getFlightId(), fb.getBookingId() } );
	}
	
	public List<FlightBookings> readAll() throws SQLException, ClassNotFoundException {
		return read("select * from flight_bookings", null);
		
	}
	
	public List<FlightBookings> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from flight_bookings where flight_id = ? or booking_id = ?", new Object[] { id });
		
	}


	@Override
	public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBookings> flightBookings = new ArrayList<>();
		while(rs.next()) {
			FlightBookings fb = new FlightBookings();
			
			fb.getFlightId().setId(rs.getInt("flight_id"));
			fb.getBookingId().setBookingNo(rs.getInt("role_id"));
			
			
			flightBookings.add(fb);
		}
		return flightBookings;
	}
}
