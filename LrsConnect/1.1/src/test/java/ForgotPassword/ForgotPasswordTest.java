package ForgotPassword;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Common.Reader;


public class ForgotPasswordTest {
	WebDriver driver;
	boolean resultDisplay;
	Reader read=new Reader();
	List<Boolean> resultList=new ArrayList<Boolean>();
	
	
	public boolean forgotPassword() throws InterruptedException {
		System.out.println("inside forgot password");
		WebElement  forgot = driver.findElement(By.id("forgotPassword"));//Forgot password Link ;
		String forgot1 = forgot.getText();
		System.out.println(forgot1);
		Thread.sleep(10000);
		
		if (forgot1.equals(read.getForgotPassword())) {
			System.out.println(forgot1 + " result passed");
			resultDisplay = true;
		} 
		else {
			resultDisplay = false;
			String Errorresult = forgot1 + " does not match with this "
					+ read.getForgotPassword();
			result(Errorresult);
		}
		Thread.sleep(10000);
		return resultDisplay;
		
	}
	
	public  boolean forgotPasswordPageTitle() throws InterruptedException {
		
		WebElement  header = driver.findElement(By.className("form-signin-heading"));//Forgot Password Title 
		String forgotPasswordPageTitle = header.getText();
		
		if (forgotPasswordPageTitle.equals(read.getForgotPassword())) {
			System.out.println(forgotPasswordPageTitle + "" + "result passed");
			resultDisplay = true;
		} else {
			resultDisplay = false;
			String Errorresult = forgotPasswordPageTitle + "does not match with this"
					+ read.getForgotPassword();
			result(Errorresult);
		}
		return resultDisplay;
	}
		
		
	public boolean resetButton() {
		WebElement  reset = driver.findElement(By.id("btnForgotSubmit"));//reset Button
		String reset1 = reset.getText();
		if (reset.isDisplayed()) {
			System.out.println(reset1 + "result passed");
		
			reset.click();
			resultDisplay = true;
		} else {
			resultDisplay = false;
			String Errorresult = reset1 + "does not match ";
			result(Errorresult);
		}
		return resultDisplay;
	}
public void result(String result) {
	if (resultDisplay == false) {
		
		String Errormessage = result + " " + "or" + "" + " "
				+ "Help link is not visible. This scenario is failed";
		System.out.println(Errormessage);
		
	} else {
		System.out.println("passed");
	}
	}
public  boolean GoBck() throws InterruptedException {
	WebElement Go = driver.findElement(By.linkText("Go Back"));//GoBack Button
	Thread.sleep(10000);
	driver.navigate().refresh();
	WebElement  forgot = driver.findElement(By.id("forgotPassword"));//Forgot password Link ;
	forgot.click();
	String strng1 = Go.getText();
	if (strng1.equals(read.getGoBack())) {
		System.out.println(strng1 + "result passed");
		resultDisplay = true;
	} else {
		resultDisplay = false;
		String Errorresult = strng1 + " does not match with this "
				+ read.getGoBack();
		result(Errorresult);
	}
	Thread.sleep(10000);
	return resultDisplay;
}
public boolean EmailField() throws InterruptedException {

	WebElement  Email = driver.findElement(By.id("j_username_error"));//Email Field for password
	String Email1 = Email.getText();
	driver.navigate().refresh();
	
	if (Email.isDisplayed()) {
		System.out.println(Email1 + "result passed");
		resultDisplay = true;
	} else {
		resultDisplay = false;
		String Errorresult = "Reset link not clicked";
		result(Errorresult);
	}
	return resultDisplay;	}


public boolean emailConfirmation() throws InterruptedException {
	WebElement Confirmmessage=driver.findElement(By.id("errorDiv"));//confirmation message
	driver.navigate().refresh();

	driver.findElement(By.id("j_username")).sendKeys(read.getUser_name());

	
	if (read.getConfirmation_Email().equals(Confirmmessage.getText())) {
		System.out.println(read.getConfirmation_Email() + "result passed");
		resultDisplay = true;
	} else {
		resultDisplay = false;
		String Errorresult = "Reset link not clicked";
		result(Errorresult);
	}
	return resultDisplay;	}

}



