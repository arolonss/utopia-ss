package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.Airport;




public class AirportDAO extends BaseDAO<Airport>{

	public AirportDAO(Connection conn) {
		super(conn);
	}
	
	public void add(Airport a) throws SQLException, ClassNotFoundException {
		saveAndReturnPrimaryKey("insert into airport (iata_id, city) values (?, ?)", new Object[] { a.getAirportCode(), a.getCity() });
	}

	public void update(Airport a) throws SQLException, ClassNotFoundException {
		save("update airport set city = ? where iata_id = ?", new Object[] { a.getCity(), a.getAirportCode() });
	}

	public void delete(Airport a) throws SQLException, ClassNotFoundException {
		save("delete from airport where iata_id = ?", new Object[] { a.getAirportCode() });
	}

	public List<Airport> readAll() throws SQLException, ClassNotFoundException {
		return read("select * from airport", null);

	}

	public List<Airport> readById(String code) throws SQLException, ClassNotFoundException {
		return read("select * from airport where iata_id = ?", new Object[] { code });
	}

	@Override
	public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		while (rs.next()) {
			Airport a = new Airport();

			a.setAirportCode(rs.getString("iata_id"));
			a.setCity(rs.getString("city"));

			airports.add(a);
		}
		return airports;
	}
}
