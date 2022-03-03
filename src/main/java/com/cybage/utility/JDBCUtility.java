package com.cybage.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.omg.CORBA.PUBLIC_MEMBER;

public class JDBCUtility {
	
	public static final String URL = "jdbc:mysql://localhost:3307/PMS";
    public static final String USER = "root";
    public static final String PASSWORD = "1234";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    //public static final String PARAMETERS = "verifyServerCertificate=false&useSSL=true";
    
    
    public static Connection getConnection() {
    	Connection conn=null;
    	
    	try {
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
    	}
		public static void disconnect(Connection conn) {
			try {
				if(conn!=null);
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		public static void main(String[] args) {
			Connection conn=getConnection();
			
			if(conn!=null) {
				System.out.println("Connected");
			}
			else {
				System.out.println("Not Connected");
			}
		}
}