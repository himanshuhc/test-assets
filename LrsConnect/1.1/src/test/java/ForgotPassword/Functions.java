package ForgotPassword;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.Reader;

public class Functions{
	
	boolean resultDisplay;
	Reader read=new Reader();
	List<Boolean> resultList=new ArrayList<Boolean>();
 WebDriver driver;
	
	@BeforeClass
	public void OpenBrowser(){
		//open browser with specified url
		driver=new FirefoxDriver();
		read.logincredentials();
		
		driver.get(read.getURL());
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void ForgotPasswordTestCases() throws InterruptedException
	
	{  
		Thread.sleep(2000);
		WebElement  forgot = driver.findElement(By.id("forgotPassword"));//Forgot password Link ;
		
		Assert.assertTrue(forgot.getText().equalsIgnoreCase(read.getForgotPassword()), "The Forgot Password link found");
		forgot.click();
		Thread.sleep(5000);
		
	}
	
	/*@Test(dependsOnMethods = { "ForgotPasswordTestCases" } )
	public void forgotPasswordTitleCheck() throws InterruptedException
	{   WebElement Title = driver.findElement(By.className("form-signin-heading"));//Forgot Password Title 
		Assert.assertTrue(Title.getText().equals(read.getForgotPassword()), "The Forgot Password Title");
		
	}*/
@Test(dependsOnMethods = { "ForgotPasswordTestCases" } )
public void GoBack()
{
	WebElement Go = driver.findElement(By.linkText("Go Back"));
	System.out.println(Go.getText());
	Assert.assertTrue(Go.getText().equalsIgnoreCase(read.getGoBack()), "GO Back link is present");
}
@Test(dependsOnMethods = { "ForgotPasswordTestCases" , "GoBack" })
public void resetButton() throws InterruptedException
{
	WebElement  reset = driver.findElement(By.id("btnForgotSubmit"));//reset Button
	
	Assert.assertTrue(reset.isDisplayed(), "Reset button is displayed");
	reset.click();
	Thread.sleep(5000);
	
}
@Test(dependsOnMethods = { "resetButton" } )
public void EmailField() throws InterruptedException
{
	WebElement  Email = driver.findElement(By.id("j_username_error"));//Email Field for password
	Assert.assertTrue(Email.isEnabled());
	System.out.println("Email Field is required");
	Email.click();
	Thread.sleep(5000);
}

@Test(dependsOnMethods = { "EmailField" , "resetButton" } )
public void EmailConfirmation() throws InterruptedException
{

	driver.findElement(By.id("j_username")).sendKeys(read.getUser_name());
	WebElement  reset = driver.findElement(By.id("btnForgotSubmit"));//reset Button
	reset.click();
	Thread.sleep(5000);
	WebElement Confirmmessage=driver.findElement(By.id("errorDiv"));//confirmation message
	Assert.assertTrue(Confirmmessage.getText().equalsIgnoreCase(read.getConfirmation_Email()), "Confirmation Email message ");
	System.out.println("Forgot password Module completed");
	
	
}
@AfterClass
public void close()
{
	driver.close();
}
}
