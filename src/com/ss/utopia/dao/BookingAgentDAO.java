package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.BookingAgent;


public class BookingAgentDAO extends BaseDAO<BookingAgent>{

	
	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	
	public void add(BookingAgent ba) throws SQLException, ClassNotFoundException {
		save("insert into booking_agent (booking_id, agent_id) values (?, ?)",
				new Object[] { ba.getBookingNo(), ba.getAgentId() });
	}
	
	
	public void update(BookingAgent ba) throws SQLException, ClassNotFoundException {
		save("update booking_agent set agent_id = ? where booking_id = ?",
				new Object[] {  ba.getAgentId().getId(), ba.getBookingNo().getBookingNo() });
	}
	

	public void delete(BookingAgent ba) throws SQLException, ClassNotFoundException {
		save("delete from booking_agent where booking_id = ?", new Object[] { ba.getBookingNo().getBookingNo() } );
	}
	
	public List<BookingAgent> readAll() throws SQLException, ClassNotFoundException {
		return read("select * from booking_agent", null);
		
	}
	
	public List<BookingAgent> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from booking_agent where booking_id = ?", new Object[] { id });
		
	}


	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> bookingAgents = new ArrayList<>();
		while(rs.next()) {
			BookingAgent ba = new BookingAgent();
			
			ba.getBookingNo().setBookingNo(rs.getInt("booking_id"));
			ba.getAgentId().setId(rs.getInt("agent_id"));
			
			
		    bookingAgents.add(ba);
		}
		return bookingAgents;
	}

}
