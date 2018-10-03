package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.Registervo;

public class managerDao {
	
	public void updatefirstname(String firstname,String username) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
	    try{
	        	con = Connectiondb.Open();
	           	System.out.println("Test Register Connection");
	            String sql = "UPDATE userlogin SET firstname = '"+ firstname+"' WHERE username = '"+ username+"' ";
	            PreparedStatement ps = con.prepareStatement(sql); 
	            ps.executeUpdate();
	        }
	        catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}	
	    
	    }
public void updatelastname(String lastname,String username) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
	    try{
	        	con = Connectiondb.Open();
	           	System.out.println("Test Register Connection");
	            String sql = "UPDATE userlogin SET lastname = '"+ lastname+"' WHERE username = '"+ username+"' ";
	            PreparedStatement ps = con.prepareStatement(sql); 
	            ps.executeUpdate();
	        }
	        catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}	
	    }
	public void updateemail(String email,String username) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
	    try{
	        	con = Connectiondb.Open();
	           	System.out.println("Test Register Connection");
	            String sql = "UPDATE userlogin SET personalemail = '"+ email+"' WHERE username = '"+ username+"' ";
	            PreparedStatement ps = con.prepareStatement(sql); 
	            ps.executeUpdate();
	        }
	        catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}	
	    }
	public void updateusername(String uname,String username) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
	    try{
	        	con = Connectiondb.Open();
	           	System.out.println("Test Register Connection");
	            String sql = "UPDATE userlogin SET username = '"+ uname+"' WHERE username = '"+ username+"' ";
	            PreparedStatement ps = con.prepareStatement(sql); 
	            ps.executeUpdate();
	        }
	        catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}	
	    }
public void updatefees(String fees,String username) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
	    try{
	        	con = Connectiondb.Open();
	           	System.out.println("Test Register Connection");
	            String sql = "UPDATE userlogin SET fees = '"+ fees+"' WHERE username = '"+ username+"' ";
	            PreparedStatement ps = con.prepareStatement(sql); 
	            ps.executeUpdate();
	        }
	        catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}	
	    }
}
