package ForgotPassword;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Reader;
import Common.SequenceNum;


public class AddUsers extends AddLocation {

	
	Reader read=new Reader();
	
	SequenceNum S_Num = new SequenceNum();
	int incrId=0;
	List<String> userList1=new ArrayList<>();
	 List<WebElement> userList=new ArrayList<WebElement>();
	 String FullName;
	
	
	
	@SuppressWarnings("static-access")
	@Test
	public void addUsers() throws InterruptedException
	{read.logincredentials();
	System.out.println("login entered for add users");
		login();
  //click account menu option
		driver.findElement(By.cssSelector("a[id='account']")).click(); 
		    Thread.sleep(5000);
		    
		    //click on users sub menu option
		    driver.findElement(By.id("users")).click();
		    Thread.sleep(10000);
		    
		    //Click on New User
		    driver.findElement(By.xpath("//div[@class='pull-right']/button")).click();
		    Thread.sleep(5000);
		    
		    //Enter Details
		    driver.findElement(By.name("firstName")).sendKeys(read.getName());
		    driver.findElement(By.name("lastName")).sendKeys(read.getLName());
		    incrId = Integer.valueOf(S_Num.nextSequenceNumber());
		   
		    /*String[] email_split=Emails.split("@");
		    String firstPart=email_split[0]+incrId;
		    String new_Email=firstPart+email_split[1];
		    */
		    String new_Email=incrId + read.getEmail();
		    System.out.println(new_Email);
		    driver.findElement(By.name("email")).sendKeys(new_Email);
		    driver.findElement(By.name("password")).sendKeys(read.getPassword());
		    WebElement savebtn=driver.findElement(By.xpath("//div[@class='mdDetailFooterRight']/button[2]"));
		    savebtn.click();
		    Thread.sleep(2000);
		    System.out.println("Save Button"+savebtn.getText());
		    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mdDetailFooterRight']/button[2]")).getText().equalsIgnoreCase("Save"), "check");
		    System.out.println("Save Button"+savebtn.getText());
		    Thread.sleep(5000);
		    //Refresh User page to reflect newly added user
		   // driver.navigate().refresh();
	}
	
	@Test(dependsOnMethods= { "addUsers" })
	public void checkUserAddition() throws InterruptedException
	{
		FullName="1"+" "+"2";
	    System.out.println(FullName);
	    
		//Check to confirm user is added successfully
	   
	    userList=driver.findElements(By.xpath("//div[@class='mdMasterScrollingWindow']/div/div/div/div[1]"));
	    Thread.sleep(5000);
	    
	    for(int i=0;i<userList.size();i++)
	    {
	    	//System.out.println(userList.get(i).getText());
	    	userList1.add(userList.get(i).getText());
	    	//Assert.assertEquals(userList.get(i).getText(),FullName);  
	    	
	    }
	    System.out.println(userList1);
	    Assert.assertTrue(userList1.contains(FullName), "message");
	}
	@Test
	 public void changePass() throws InterruptedException
	 {
	  for (int j=0;j<userList.size();j++)
	  {
	   if(userList.get(j).getText().equals(FullName))
	       {
	        //Click on newly added user from the left panel
	        userList.get(j).click();  
	        Thread.sleep(5000);
	       }
	  }
	  //change password
	     driver.findElement(By.xpath("//div[@class='mdDetailFooterLeft']/button[2]")).click();
	     Thread.sleep(5000);
	     
	     //Enter new & confirm password details & Save
	     driver.findElement(By.id("newPasswordInput")).click();
	     driver.findElement(By.id("newPasswordInput")).sendKeys("password2");
	     driver.findElement(By.id("confirmNewPasswordInput")).click();
	     driver.findElement(By.id("confirmNewPasswordInput")).sendKeys("password2");
	     driver.findElement(By.id("modalSave")).click();
	 }
	 
	 @Test
	 public void delUser() throws InterruptedException
	 {
	  //Permanently Delete newly added user 
	     driver.findElement(By.xpath("//div[@class='mdDetailFooterLeft']/button[1]")).click();
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//div[@class='modal-footer']/button[2]")).click();
	     Thread.sleep(5000);
	     userList=driver.findElements(By.xpath("//div[@class='mdMasterScrollingWindow']/div/div/div/div[1]"));
	     Thread.sleep(5000);

	 }
	 
	 @Test(dependsOnMethods="delUser") 
	 public void confirmDelUser()
	 {
	  //Confirm newly added user gets deleted
	     for(int i=0;i<userList.size();i++)
	     {
	      userList1.add(userList.get(i).getText());
	     }
	     
	     Assert.assertTrue(userList1.contains(FullName), "User got deleted");
System.out.println("Add User Module Completed");
	 }

}
