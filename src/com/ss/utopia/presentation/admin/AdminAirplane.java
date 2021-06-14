package com.ss.utopia.presentation.admin;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.model.Airplane;
import com.ss.utopia.service.AdminService;

public class AdminAirplane implements AdminCrud<Airplane> {

	private AdminService admin;
	static Scanner sc = new Scanner(System.in);

	public AdminAirplane(AdminService admin) {
		super();
		this.admin = admin;
	}
	
	public void add() throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	
	public List<Airplane> readAll() throws ClassNotFoundException, SQLException {
		return admin.readAllAirplanes();
		
	}


	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}


	public void add(Integer role) throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Integer id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public void delete(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
