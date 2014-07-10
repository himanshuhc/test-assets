	package Common;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reader { 
	private String pass_word;
	private String password;
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}





	private String user_name;
	private String URL;
	private String filename="loginCredentials.properties";
	private String ForgotPassword;
	private String GoBack;
	private String Confirmation_Email;
	private String Name;
	private String Address;
	private String Address2;
	private String State;
	private String Zipcode;
	private String City;
	private String Email;
	private String LName;
	public String getLName() {
		return LName;
	}


	public void setLName(String lName) {
		LName = lName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getAddress2() {
		return Address2;
	}


	public void setAddress2(String address2) {
		Address2 = address2;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}


	public String getZipcode() {
		return Zipcode;
	}


	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}





	

 
 public String getConfirmation_Email() {
		return Confirmation_Email;
	}


	public void setConfirmation_Email(String confirmation_Email) {
		Confirmation_Email = confirmation_Email;
	}


public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


public String getGoBack() {
		return GoBack;
	}


	public void setGoBack(String goBack) {
		GoBack = goBack;
	}


public String getForgotPassword() {
		return ForgotPassword;
	}


	public void setForgotPassword(String forgotPassword) {
		ForgotPassword = forgotPassword;
	}


public String getUser_name() {
	return user_name;
}


public void setUser_name(String user_name) {
	this.user_name = user_name;
}


public String getPass_word() {
	return pass_word;
}


public void setPass_word(String pass_word) {
	this.pass_word = pass_word;
}


public String getURL() {
	return URL;
}


public void setURL(String uRL) {
	URL = uRL;
}



 

public void logincredentials()
{
 
 Properties properties = new Properties();
 try {
 properties.load(new FileInputStream(filename));
} catch (FileNotFoundException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
} catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
}
 this.setURL(properties.getProperty("URL"));
 this.setUser_name(properties.getProperty("user_name"));
 this.setPass_word(properties.getProperty("pass_word"));
 this.setForgotPassword(properties.getProperty("ForgotPassword"));
 this.setGoBack(properties.getProperty("GoBack"));
 this.setConfirmation_Email(properties.getProperty("Confirmation_Email"));
 this.setAddress(properties.getProperty("Address"));
 this.setAddress2(properties.getProperty("Address2"));
 this.setState(properties.getProperty("State"));
 this.setName(properties.getProperty("Name"));
 this.setZipcode(properties.getProperty("Zipcode"));
 this.setCity(properties.getProperty("City"));
 this.setEmail(properties.getProperty("Email"));
 this.setLName(properties.getProperty("LName"));
 this.setPassword(properties.getProperty("password"));
 
 
 

}





}