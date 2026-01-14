package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	public void getConnection(String url,String username,String password) throws Throwable
	{ 
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(url,username,password);
	}catch(Exception e){}

	}
	
	public void closeDBConnection() throws Throwable
	{
		try {
		con.close();
		}catch(Exception e) {}
	}
	
	public ResultSet executeSelectQuery(String query) throws Throwable
	{
		ResultSet result=null;
		try {
		Statement st = con.createStatement();
	    result = st.executeQuery(query);
	    
		}catch(Exception e) {}
		return result;
	}
	
	public boolean executeCreateSelectQuery(String query) throws Throwable
	{
		boolean result=false;
		try {
		Statement st = con.createStatement();
	    result = st.execute(query);
	    
		}catch(Exception e) {}
		return result;
	}
	
	public int executeNonSelectQuery(String query) throws Throwable
	{
		int result=0;
		try {
		Statement st = con.createStatement();
	     result = st.executeUpdate(query);
	    
		}catch(Exception e) {}
		return result;
	}
}
