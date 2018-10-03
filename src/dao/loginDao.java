package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.context.FacesContext;

import dao.Connectiondb;
import Model.Loginvo;

public class loginDao {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	
	public Loginvo login(Loginvo loginvo) throws Exception{
		
		String username = loginvo.getUsername();
		String password = loginvo.getPassword();
		String role = loginvo.getRole();
		
		String dbusername,dbpassword;
	    
		try{
        	con = Connectiondb.Open();
        	
        	System.out.println("Test Login Connection");
            String sql = "SELECT * FROM userlogin where username=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet resultSet = ps.executeQuery();
        
        /*
            if (resultSet.next()) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", resultSet.getString("username"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uid", resultSet.getString("uid"));
                //System.out.println("uid: " + rs.getString("uid"));
                //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key,object);
                Connectiondb.Close(con);
                return null;
            }*/
            System.out.println("Login Query Executed");
            
            while(resultSet.next()){
            	dbusername = resultSet.getString("username");
				dbpassword = resultSet.getString("password");
				
				if(dbusername.equals(username) && dbpassword.equals(password)){
			
					loginvo.setFirstname(resultSet.getString("firstname"));
					loginvo.setLastname(resultSet.getString("lastname"));
					loginvo.setRole(resultSet.getString("role"));
					loginvo.setBalance(resultSet.getInt("balance"));
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", resultSet.getString("username"));
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("balance", resultSet.getString("balance"));
		      //      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uid", resultSet.getString("uid"));
		             
					System.out.println("Test inside login");
					return loginvo;
				}
				

	            else{
	            	return null;
	            }
            }
            
        }
        catch(Exception e)
		{
			e.printStackTrace(); 
			System.out.println(e);
		}	
		return null;
    }

}
