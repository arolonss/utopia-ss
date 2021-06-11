package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.BookingPayment;


public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	
	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	
	public void add(BookingPayment bp) throws SQLException, ClassNotFoundException {
		save("insert into booking_payment (booking_id, user_id) values (?, ?, ?)",
				new Object[] { bp.getBookingId(), bp.getStripeId(), bp.isRefunded()  });
	}
	
	
	
	public void update(BookingPayment bp) throws SQLException, ClassNotFoundException {
		save("update booking_payment set stripe_id = ?, refunded = ? where booking_id = ?",
				new Object[] {  bp.getStripeId(), bp.isRefunded(), bp.getBookingId() });
	}
	

	public void delete(BookingPayment bp) throws SQLException, ClassNotFoundException {
		save("delete from booking_payment where booking_id = ?", new Object[] { bp.getBookingId() } );
	}
	
	public List<BookingPayment> readAll() throws SQLException, ClassNotFoundException {
		return read("select * from booking_payment", null);
		
	}
	
	public List<BookingPayment> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from booking_payment where booking_id = ?", new Object[] { id });
		
	}


	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> bookingPayments = new ArrayList<>();
		while(rs.next()) {
			BookingPayment bp = new BookingPayment();
			
			bp.getBookingId().setBookingNo(rs.getInt("booking_id"));
			bp.setStripeId(rs.getString("stripe_id"));
			bp.setRefunded(rs.getBoolean("refunded"));
			
		    bookingPayments.add(bp);
		}
		return bookingPayments;
	}
}
