package bookstore;

import java.util.HashMap;

public class AdminDetails {

	private HashMap<String, String> admin;

	public AdminDetails(HashMap<String, String> admin) {

		this.admin = admin;
	}

	public AdminDetails() {

		admin = new HashMap<String, String>();
		admin.put("admin1", "admin112");
		admin.put("admin2", "admin212");
		admin.put("admin3", "admin312");
		admin.put("admin4", "admin412");
	}

	public Boolean validateUser(String useradmin, String password)
	{
		if(admin.containsKey(useradmin) && admin.containsValue(password))
		{
			System.out.println("VALID ADMIN");
			return true;
		}
		return false;
	}


}
