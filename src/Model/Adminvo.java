package Model;

public class Adminvo {
	public String firstname;
	public String lastname;
	public String username;
	public String personalemail;
	public int fees;
	
	public String currentstatus;

	public String getCurrentstatus() {
		return currentstatus;
	}

	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	
	public Adminvo(String firstname, String lastname, String username, String personalemail, int fees)
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.personalemail = personalemail;
		this.fees = fees;
		
	}
	public Adminvo(){
		super();
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPersonalemail() {
		return personalemail;
	}

	public void setPersonalemail(String personalemail) {
		this.personalemail = personalemail;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}
		
	
}
