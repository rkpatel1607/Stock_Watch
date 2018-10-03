package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import dao.Connectiondb;
import Model.Adminvo;

public class adminDao {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	
	public List<Adminvo> getpendingRequest(){
			
		List<Adminvo> pendinRequest = new ArrayList<Adminvo>();
    
		try{
        	con = Connectiondb.Open();
        	
        	System.out.println("Test Login Connection");
            String sql = "SELECT * FROM userlogin where status = 'InActive'";
            PreparedStatement ps = con.prepareStatement(sql); 
                    
            
            ResultSet resultSet = ps.executeQuery();
        
            System.out.println("Pending Request Query Executed");
            
            while(resultSet.next()){
            	Adminvo adminvo = new Adminvo();
            	adminvo.setFirstname(resultSet.getString("firstname"));
            	adminvo.setLastname(resultSet.getString("lastname"));
            	adminvo.setUsername(resultSet.getString("username"));
            	adminvo.setPersonalemail(resultSet.getString("personalemail"));
            	adminvo.setFees(resultSet.getInt("fees"));	
            	pendinRequest.add(adminvo);
            	
            }
            
            
            for(Adminvo x:pendinRequest)
            {
            	System.out.println("name:"+x.getUsername());
            }
            
            
        }
        catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
			return null;
		}	
		return pendinRequest;
    }
	
	public void accept(String username) throws Exception{
		try {
			con = Connectiondb.Open();
			System.out.println("Request accept dao:"+username);
			/*String sql1 = "SELECT * FROM userlogin where status = 'InActive' && username='"+username+"'";
			preparedStatement = (PreparedStatement) con.prepareStatement(sql1);	
			ResultSet resultSet = preparedStatement.executeQuery();
        	
			while(resultSet.next()){
				System.out.println("");
			*/	System.out.println("ADMIN DAO INSIDE UPDATE QUERY");
				String sql = "UPDATE userlogin SET status = 'Active' where username='"+username+"'";
				System.out.print("accept sql is running now..." + sql);
				preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				int i=preparedStatement.executeUpdate(sql);
				if(i>0)
				{
					System.out.println("updated.");
					return;
				}
				/*}
			*/
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
