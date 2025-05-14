package com.online_shopping.ecomm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	Connection con;

	public void getDbConnection(String url, String username, String password) throws Throwable {

		try {

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println("handled");
		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;

		try {
			Statement st = con.createStatement();
			result = st.executeQuery(query);
		} catch (Exception e) {
			System.out.println("handled");
		}

		return result;

	}

	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {

			Statement st = con.createStatement();
			result = st.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Handled");
		}

		return result;
	}
	
	public void closeDbConnection() {
		try {
			con.close();
		}catch(Exception e) {
			System.out.println("Handled");
		}
	}
}
