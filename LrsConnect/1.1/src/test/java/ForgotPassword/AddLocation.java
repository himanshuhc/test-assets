package ForgotPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Reader;
import Common.SequenceNum;


public class AddLocation extends Functions  {

	


	Reader read=new Reader();
	
	
	
	SequenceNum S_Num = new SequenceNum();
	@SuppressWarnings("static-access")
	int  incrId = Integer.valueOf(S_Num.nextSequenceNumber());
	 String LocationName;
	 
		public void login() throws InterruptedException
		{read.logincredentials();
		 System.out.println("in this method");
		//Thread.sleep(5000);
		//driver.navigate().refresh();
		driver.findElement(By.cssSelector("*[id='j_username']")).sendKeys(read.getUser_name());
	    driver.findElement(By.id("j_password")).sendKeys(read.getPass_word());
	    driver.findElement(By.id("btnLoginSubmit")).click();
	    Thread.sleep(5000);
		}
	 @Test
	public void addLocation() throws InterruptedException
	{ 
		 login();
   System.out.println("after add location login");
		 driver.findElement(By.cssSelector("a[id='account']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector("button[class='btn newModelBtn']")).click();
		
		 LocationName = incrId + read.getName() + incrId;
		 //Adding values
	      driver.findElement(By.name("name")).sendKeys(LocationName);
	      driver.findElement(By.name("addressLine1")).sendKeys(read.getAddress());
	      driver.findElement(By.name("addressLine2")).sendKeys(read.getAddress2());
	      driver.findElement(By.name("city")).sendKeys(read.getCity());
	      driver.findElement(By.name("province")).sendKeys(read.getState());
	      driver.findElement(By.name("zipCode")).sendKeys(read.getZipcode());
	      WebElement save=driver.findElement(By.xpath("//*[@class='mdDetailFooterRight']/child::button[2]"));
	      Assert.assertTrue(save.isDisplayed(), "save Button");
	      System.out.println("Adding Location Completed");
	      save.click();
	      Thread.sleep(5000);
	}
	      @Test
	      public void deleteLocation() throws InterruptedException{
	    	  
	     
	      WebElement Delete=driver.findElement(By.cssSelector("button[class='btn deleteModelBtn']"));
	    		Assert.assertTrue(Delete.isDisplayed()); 
	    		System.out.println("Delete Button Available");
	    		Delete.click();
	      driver.findElement(By.cssSelector("span[name='confirmButtonLabel']")).click();
	      Thread.sleep(2000);
	      System.out.println("Add Location Module Completed");
	   }
	}


