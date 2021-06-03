/**
 * 
 */
package com.dss.utopia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;


/**
 * @author amanda
 *
 */
public class ReadAirport {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url= "jdbc:mysql://localhost:3306/utopia?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "rootpassword";
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Register the driver 
		Class.forName(driver);
		// create Connection
		Connection conn = DriverManager.getConnection(url, username, password);
        // statement
		//Statement stmt = conn.createStatement();
		// you can only have one PreparedStatement
		PreparedStatement pstmt = conn.prepareStatement("select * from airport where iata_id like ?");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Airport code to search: ");
		String airportCode = sc.nextLine();
		sc.close();
		pstmt.setString(1, airportCode); //based on datatype
		//String sql = "select * from airport where iata_id like '"+airportCode+"'"; // replace like with =
		//String sql = "select * from airport";
		//ResultSet rs = stmt.executeQuery();
		ResultSet rs = pstmt.executeQuery(); // .executeBatch commits by default 
		while(rs.next()) {
			System.out.println(rs.getString("iata_id"));
			System.out.println(rs.getString("city"));
		}
	}

}
