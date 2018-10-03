package Controller;
	import java.util.ArrayList;
	import java.util.List;

	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.SessionScoped;
	import javax.faces.context.FacesContext;

	import dao.adminDao;
	import Model.Adminvo;

	@SessionScoped
	@ManagedBean(name="admin")
	public class AdminBean {

		//private adminVO adminvo = new adminVO();
		adminDao admindao = new adminDao();
		private List<Adminvo> pendingRequest = new ArrayList<Adminvo>();
		
		public List<Adminvo> getPendingRequest() throws Exception {
			pendingRequest = admindao.getpendingRequest();
			return pendingRequest;
		}
		public void setPendingRequest(List<Adminvo> pendingRequest) {
			this.pendingRequest = pendingRequest;
		}
		
		public String acceptRequest(String username){
			adminDao admindao = new adminDao();
		
			System.out.println("username accept request:"+username);
			System.out.println("In Admin controller" + username);
			try {
				admindao.accept(username);
				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Accept","Sucessfully Accepted");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "adminHome?faces-redirect=true";
			}
		
	}
