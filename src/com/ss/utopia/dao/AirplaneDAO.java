package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.model.Airplane;
import com.ss.utopia.model.User;

public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	public void add(Airplane a) throws SQLException, ClassNotFoundException {
		saveAndReturnPrimaryKey("insert into airplane (type_id) values (?)", new Object[] { a.getTypeId() });
	}

	public void update(Airplane a) throws SQLException, ClassNotFoundException {
		save("update aiplane set role_id = ? where id = ?", new Object[] { a.getTypeId(), a.getId() });
	}

	public void delete(User u) throws SQLException, ClassNotFoundException {
		save("delete from user where id = ?", new Object[] { u.getId() });
	}

	public List<Airplane> read() throws SQLException, ClassNotFoundException {
		return read("select * from airplane", null);

	}

	public List<Airplane> readById(Integer id) throws SQLException, ClassNotFoundException {
		return read("select * from airplane where id = ?", new Object[] { id });
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<>();
		while (rs.next()) {
			Airplane a = new Airplane();

			a.setId(rs.getInt("id"));
			a.getTypeId().setId(rs.getInt("type_id"));

			airplanes.add(a);
		}
		return airplanes;
	}

}
