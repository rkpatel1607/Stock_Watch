package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiondb {

	public static Connection Open() throws SQLException 
	{
		Connection con = null;
		
		com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
		ds.setServerName(System.getenv("ICSI518_SERVER"));
		ds.setPortNumber(Integer.parseInt(System.getenv("ICSI518_PORT")));
		ds.setDatabaseName(System.getenv("ICSI518_DB"));
		ds.setUser(System.getenv("ICSI518_USER"));
		ds.setPassword(System.getenv("ICSI518_PASSWORD"));
		con = ds.getConnection();
		return con;
		
		}
	
	public static void Close(Connection con) {
		// TODO Auto-generated method stub
		try{
			con.close();
		} catch (Exception e) { 
			e.printStackTrace();
			}
	}
	
}
