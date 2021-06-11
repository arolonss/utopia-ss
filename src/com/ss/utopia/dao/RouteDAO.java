package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.Route;

public class RouteDAO extends BaseDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);

	}

	public void addRoute(Route route) throws SQLException, ClassNotFoundException {
		save("insert into route (?, ?)",
				new Object[] { route.getOrgId().getAirportCode(), route.getDestId().getAirportCode() });
	}

	public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
		save("update route set origin_id = ? " + "and destination_id = ? where id = ?",
				new Object[] { route.getOrgId().getAirportCode(), route.getDestId().getAirportCode(), route.getId() });
	}

	public List<Route> readAllRoutes(Route route) throws ClassNotFoundException, SQLException {
		return read("select * from routes", null);

	}

	public List<Route> readRoutesbyAirportCode(String airportCode) throws ClassNotFoundException, SQLException {
		return read("select * from route where destination_id = ? or origin_id = ?",
				new Object[] { airportCode, airportCode });
	}

	public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
		save("delete from route where id = ?", new Object[] { route.getId() });
	}

	@Override
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		while (rs.next()) {
			Route r = new Route();
			r.setId(rs.getInt("id"));
			r.getOrgId().setAirportCode(rs.getString("origin_id"));
			r.getDestId().setAirportCode(rs.getString("destination_id"));
			routes.add(r);
		}
		return routes;
	}

}
