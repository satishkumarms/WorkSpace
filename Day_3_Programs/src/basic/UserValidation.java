package basic;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserValidation {

	private String username;
	private String password;

	/*public String getUsername() {
		return username;
	}*/
	public void setUsername(String username) {
		this.username = username;
	}
	/*public String getPassword() {
		return password;
	}*/
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean validateUserName()
	{
		BufferedReader br = null;
		String fusername,fields[];
		try {
			br = new BufferedReader(new FileReader("userpassword.txt"));
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while((fusername = br.readLine())!=null)
			{
				//String[] fusername = br.readLine().split(",");
				fields = fusername.split(",");
				if(password.equals(fields[0]))
				{
					return true;
				}


			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public Boolean validateUserPassword()
	{
		BufferedReader br = null;
		String fusername,fields[];

		try {
			br = new BufferedReader(new FileReader("userpassword.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while((fusername = br.readLine())!=null)
			{
				//String[] fusername = br.readLine().split(",");
				fields = fusername.split(",");
				if(password.equals(fields[1]))
				{
					return true;
				}


			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}

