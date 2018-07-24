package account;

import java.util.Date; 

public class UserAccount {

	private String username;
	private String name;
	//private String lastname;
	private String pancardno;
	private  String date; 
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPancardno() {
		return pancardno;
	}



	public void setPancardno(String pancardno) {
		this.pancardno = pancardno;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getForgotpassques() {
		return forgotpassques;
	}



	public void setForgotpassques(String forgotpassques) {
		this.forgotpassques = forgotpassques;
	}



	public String getForgotpassans() {
		return forgotpassans;
	}



	public void setForgotpassans(String forgotpassans) {
		this.forgotpassans = forgotpassans;
	}



	/*public String getPassword() {
		return password;
	}*/



	public void setPassword(String password) {
		this.password = password;
	}



	private String forgotpassques;
	private String forgotpassans;
	private String password;



	public String generateUsername()
	{
		username = name.substring(0,3)+pancardno.substring(0, 3)+date.substring(3, 2);
		return username;

	}
 









}
