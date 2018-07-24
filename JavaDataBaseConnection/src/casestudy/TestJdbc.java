package casestudy;

public class TestJdbc {
	
	public static void main(String[] args)
	{
		LoginDao loginDao = new LoginDao();
		//System.out.println(loginDao.addLogin("user3", "pass2", "user")+ " records added");
		
	int n = loginDao.deleteLogin("user3");
	}

}
