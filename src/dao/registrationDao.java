package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.Connectiondb;
import Model.Registervo;

public class registrationDao {

	Connection con = null;
	PreparedStatement preparedStatement = null;
    //Registration Object Managerloginvo
    public boolean register(Registervo registervo) throws Exception{
        try{
        	con = Connectiondb.Open();
        	String role = registervo.getRole();
        	System.out.println("Test Register Connection");
            String sql = "INSERT into userlogin (role, firstname, lastname, personalemail, username, password, fees) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, registervo.getRole());
            ps.setString(2, registervo.getFirstname());
            ps.setString(3, registervo.getLastname());
            ps.setString(4, registervo.getPersonalemail());
            ps.setString(5, registervo.getUsername());
            ps.setString(6, registervo.getPassword());
            ps.setInt(7, registervo.getFees());
            
            ps.executeUpdate();
            if(role.equals("manager")){
            	System.out.println("Status Inactive");
            	String sql2 = "update userlogin set status = 'InActive' where role = 'manager'";
            	PreparedStatement ps2 = con.prepareStatement(sql2);
            	ps2.executeUpdate();
            }
            else if(role.equals("user")){
            	System.out.println("Status null with user");
            	String sql3 = "update userlogin set fees = null where role = 'user'";
            	PreparedStatement ps3 = con.prepareStatement(sql3);
            	ps3.executeUpdate();
            }
            
            
            
        }
        catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}	
		return false;
    }

}
