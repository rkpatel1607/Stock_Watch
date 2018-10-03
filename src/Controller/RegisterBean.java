package Controller;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Model.Registervo;
import dao.registrationDao;

@ManagedBean(name="RegisterBean")
@SessionScoped
public class RegisterBean {


	Registervo regvo = new Registervo();
	
	
	
	public Registervo getRegvo() {
		return regvo;
	}



	public void setRegvo(Registervo regvo) {
		this.regvo = regvo;
	}



	public String createResigerForm(){
		
		registrationDao regdao = new registrationDao();
		
		try {
			regdao.register(regvo);
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Sucess","Sucessfully Registerd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "login";}
	
	
}
