package assignment1;

import java.util.HashMap;
import java.util.Scanner;

public class Admin {
	
	private String adminname;
	private String adminpass;
	private HashMap<String, String> admindetails;
	
	
	public Admin() {
		admindetails = new HashMap<String, String>();
		admindetails.put("admin1", "pass1");
		admindetails.put("admin2", "pass2");
		admindetails.put("admin3", "pass3");
		admindetails.put("admin4", "pass4");
		admindetails.put("admin5", "pass5");
		
	}

	public Admin(String adminname, String adminpass, HashMap<String, String> admindetails) {
		
		this.adminname = adminname;
		this.adminpass = adminpass;
		this.admindetails = admindetails;
	}


	public String getAdminname() {
		return adminname;
	}


	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}


	public String getAdminpass() {
		return adminpass;
	}


	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}


	public HashMap<String, String> getAdmindetails() {
		return admindetails;
	}


	public void setAdmindetails(HashMap<String, String> admindetails) {
		this.admindetails = admindetails;
	}
	
	public Boolean validateAdmin()
	{
		System.out.println("Enter the UserAdmin");
		adminname = new Scanner(System.in).next();
		System.out.println("Enter the AdminPassword");
		adminpass = new Scanner(System.in).next();
		if(admindetails.containsKey(adminname) && admindetails.containsValue(adminpass))
		{
			System.out.println("Successful login");
			return true;
		}
		return false;
	}
	
}
