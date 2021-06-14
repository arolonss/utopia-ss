package com.ss.utopia.presentation.admin;

import java.sql.SQLException;
import java.text.ParseException;

import com.ss.utopia.model.Passenger;
import com.ss.utopia.service.AdminService;

public class AdminPassenger implements AdminCrud<Passenger>{
	AdminService admin;

	public AdminPassenger(AdminService admin) {
		this.admin = admin;
	}


	@Override
	public void add() throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Integer role) throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Integer id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
