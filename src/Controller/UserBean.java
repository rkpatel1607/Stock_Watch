package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.userDao;
import dao.registrationDao;
@ManagedBean(name="UserBean")
@SessionScoped
public class UserBean {
	
	private String firstname;
	private String lastname;
	private String personalemail;
	private String username;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPersonalemail() {
		return personalemail;
	}
	public void setPersonalemail(String personalemail) {
		this.personalemail = personalemail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String updatefirstname(String firstname){
		
		
		String uname = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
		
		System.out.println("The Firstname is:"+firstname);
		System.out.println("Username is:"+uname);
		 userDao dao = new userDao();
		 dao.updatefirstname(firstname,uname);
		 
		return "Userhome";
	}
	
		 public String updatelastname(String lastname){
					
			String uname1 = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
			
			System.out.println("The Lastname is:"+lastname);
			System.out.println("Username is:"+uname1);
			 userDao dao = new userDao();
			 dao.updatelastname(lastname,uname1);
			 
			return "Userhome";
		 }	
			public String updateemail(String email){
				
				
				String uname2 = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
				
				System.out.println("The email is:"+email);
				System.out.println("Username is:"+uname2);
				 userDao dao = new userDao();
				 dao.updateemail(email,uname2);
				 
				return "Userhome";
			}	
				public String updateusername(String username){
					
					
					String uname3 = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
					
					System.out.println("The Username is:"+username);
					System.out.println("Username is:"+uname3);
					 userDao dao = new userDao();
					 dao.updateusername(username,uname3);
					 
					return "Userhome";
	}
	
	public String userprofile(){
		return "Userprofile";
	}
	public String userhome(){
		return "Userhome";
	}
	public String useractivity(){
		return "Useractivity";
	}
	
}
