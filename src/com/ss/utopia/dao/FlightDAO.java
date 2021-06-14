package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.Airplane;
import com.ss.utopia.model.Flight;
import com.ss.utopia.model.Route;

public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn){
		super(conn);
	}

	public void addFlight(Flight flight) throws SQLException, ClassNotFoundException {
		saveAndReturnPrimaryKey("insert into flight (id, route_id, airplane_id, departure_time, reserved_seats, seat_price) values (?, ?, ?, ?, ?, ?)",
				new Object[] { flight.getId(), flight.getRouteId().getId(), flight.getAirplaneId().getId(), flight.getDepTime(), flight.getReservedSeats(), flight.getSeatPrice() });
	}
	
	public void updateFlight(Flight flight) throws SQLException, ClassNotFoundException {
		save("update flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?",
				new Object[] { flight.getRouteId(), flight.getAirplaneId(), flight.getDepTime(), flight.getReservedSeats(), flight.getSeatPrice(), flight.getId() });
	}
	

	public void deleteFlight(Flight flight) throws SQLException, ClassNotFoundException {
		save("delete from flight where id = ?", new Object[] { flight.getId() } );
	}
	
	public List<Flight> readAllFlights() throws SQLException, ClassNotFoundException {
		return read("select * from flight", null);
		
	}
	
	public List<Flight> readFlightById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from flight where id = ?", new Object[] { id });
		
	}
	
	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		while(rs.next()) {
			Flight f = new Flight();
			Route r = new Route();
			Airplane a = new Airplane();
			r.setId(rs.getInt("route_id"));
			f.setRouteId(r);
			
			
			a.setId(rs.getInt("airplane_id"));
			
			f.setId(rs.getInt("id"));
			
			f.setAirplaneId(a);
			f.setDepTime(rs.getTimestamp("departure_time"));
			f.setReservedSeats(rs.getInt("reserved_seats"));
			f.setSeatPrice(rs.getFloat("seat_price"));
			
			flights.add(f);
		}
		return flights;
	}



}
