package com.tekpyramid.vtiger.generic.databaseutility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
import com.tekpyramid.vtiger.generic.fileutility.PropertiesUtility_2;

public class DataBaseUtility_2 {
	
	Connection conn;
	PropertiesUtility_2 pu = new PropertiesUtility_2();

	// To Connect To DB
	public void getConnectToDataBase_2() throws SQLException, IOException {
	try {
		String url = pu.getDataFromProperties_2("dburl");
		String username = pu.getDataFromProperties_2("dbusername");
		String password = pu.getDataFromProperties_2("dbpassword");
		Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        conn = DriverManager.getConnection(url,username,password);
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	// To Close The Connection With DB
	public void closeConnectionWithDB_2() throws SQLException {
		try {
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// To Fetch the Data From DB
	public ResultSet getDataFromDataBase_2(String SelectQuery) throws IOException, SQLException {
		ResultSet result = null;
		try {
			String url = pu.getDataFromProperties_2("dburl");
			String username = pu.getDataFromProperties_2("dbusername");
			String password = pu.getDataFromProperties_2("dbpassword");
			Driver driver = new Driver();
	        DriverManager.registerDriver(driver);
	        Connection conn = DriverManager.getConnection(url,username,password);
	        Statement state = conn.createStatement();
	        result = state.executeQuery(SelectQuery);
	        conn.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	// To update the Data To DB
		public int setDataBackToDataBase_2(String updateQuery) throws IOException, SQLException {
			int result = 0;
			try {
				String url = pu.getDataFromProperties_2("dburl");
				String username = pu.getDataFromProperties_2("dbusername");
				String password = pu.getDataFromProperties_2("dbpassword");
				Driver driver = new Driver();
		        DriverManager.registerDriver(driver);
		        Connection conn = DriverManager.getConnection(url,username,password);
		        Statement state = conn.createStatement();
		        result = state.executeUpdate(updateQuery);
		        conn.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return result;
		}
}
