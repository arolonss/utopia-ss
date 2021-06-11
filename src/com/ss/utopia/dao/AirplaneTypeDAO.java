package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.AirplaneType;


public class AirplaneTypeDAO extends BaseDAO<AirplaneType>{

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	public void add(AirplaneType at) throws SQLException, ClassNotFoundException {
		saveAndReturnPrimaryKey("insert into airplane_type (type_id, max_capacity) values (?, ?)", new Object[] { at.getId(), at.getMaxCap() });
	}

	public void update(AirplaneType at) throws SQLException, ClassNotFoundException {
		save("update aiplane_type set id = ? where id = ?", new Object[] { at.getMaxCap(), at.getId() });
	}

	public void delete(AirplaneType at) throws SQLException, ClassNotFoundException {
		save("delete from airplane_type where id = ?", new Object[] { at.getId() });
	}

	public List<AirplaneType> read() throws SQLException, ClassNotFoundException {
		return read("select * from airplane_type", null);

	}

	public List<AirplaneType> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from airplane_type where id = ?", new Object[] { id });
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> airplaneTypes = new ArrayList<>();
		while (rs.next()) {
			AirplaneType at = new AirplaneType();

			at.setId(rs.getInt("id"));
			at.setMaxCap(rs.getInt("max_capacity"));

			airplaneTypes.add(at);
		}
		return airplaneTypes;
	}
}
