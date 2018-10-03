package Controller;

import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;

import Model.Loginvo;
import dao.loginDao;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {
	
	Loginvo loginvo = new Loginvo();
	

	
	public Loginvo getLoginvo() {
		return loginvo;
	}

	public void setLoginvo(Loginvo loginvo) {
		this.loginvo = loginvo;
	}



	public String loginForm(){
		loginDao logindao = new loginDao();
		try {
			Loginvo login = logindao.login(loginvo);
			String role = login.getRole();
			System.out.println("role:"+role);
			if(login!=null){
				if(role.equals("user")){
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",login.getUsername());
					return "Userhome?faces-redirect=true";
				}
			else if(role.equals("manager")){
				System.out.println("manager:"+login.getUsername());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",login.getUsername());
				return "manageHome?faces-redirect=true";
			}
			else if(role.equals("Admin")){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",login.getUsername());
				return "adminHome?faces-redirect=true";
			}
			else{
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("error","please Check Id & Password");
			}
		}
	} catch (Exception e) {
			// TODO: handle exception
		}
		return "login?faces-redirect=true";
		
	}

	public String LogoutMethod() {
		System.out.println("Not Found...");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

	
}
