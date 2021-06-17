package com.ss.utopia.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ss.utopia.model.Airport;
import com.ss.utopia.service.AdminService;

@RestController
public class AirportController {

	AdminService adminService;
//	AirportService airportService;
	
	@RequestMapping(path = "/utopia/airports/{id}", method = RequestMethod.GET)
	public Airport getAirportById(@PathVariable String id) throws SQLException {
		return adminService.readAirportByCode(id);
	}

}
