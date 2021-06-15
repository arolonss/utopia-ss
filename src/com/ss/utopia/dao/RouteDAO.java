package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.Airport;
import com.ss.utopia.model.Route;

public class RouteDAO extends BaseDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);

	}

	public void addRoute(Route route) throws SQLException, ClassNotFoundException {
		saveAndReturnPrimaryKey("insert into route (origin_id, destination_id) values (?, ?)",
				new Object[] { route.getOrgId().getAirportCode(), route.getDestId().getAirportCode() });
	}

	public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
		save("update route set origin_id = ? " + "and destination_id = ? where id = ?",
				new Object[] { route.getOrgId().getAirportCode(), route.getDestId().getAirportCode(), route.getId() });
	}

	public List<Route> readAllRoutes() throws ClassNotFoundException, SQLException {
		return read("select * from routes", null);

	}

	public List<Route> readRouteById(Integer routeId) throws ClassNotFoundException, SQLException {
		return read("select * from route where id = ?", new Object[] { routeId });
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
			Airport org = new Airport();
			Airport dest = new Airport();
			
			
			r.setId(rs.getInt("id"));
			System.out.println("in dao extract data");
			org.setAirportCode(rs.getString("origin_id"));
			r.setOrgId(org);
			dest.setAirportCode(rs.getString("destination_id"));
			r.setDestId(dest);

			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("origin_id"));
			System.out.println(rs.getString("destination_id"));
		
			System.out.println("in dao extract data done");
			

			routes.add(r);
		}
		System.out.println(routes + "from extract data");
		return routes;
	}


}
