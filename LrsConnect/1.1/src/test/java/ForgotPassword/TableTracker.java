package ForgotPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Common.Reader;
import Common.SequenceNum;

public class TableTracker extends AddLocation{
	
Reader read=new Reader();
	
	SequenceNum S_Num = new SequenceNum();
	@SuppressWarnings("static-access")
	int  incrId = Integer.valueOf(S_Num.nextSequenceNumber());
	
@Test
	public void searchForCreatedLocation() throws Exception
	{
		System.out.println("IN table tracker");
		login();
		
		Thread.sleep(10000);
	System.out.println("Exit Login");
		driver.findElement(By.id("mdSearchBox")).sendKeys("Test");
		//System.out.println(a.LocationName);
	Thread.sleep(10000);
	driver.findElement(By.className("mdMasterTableSecondaryLabel")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn addProductBtn']")).click();
		Thread.sleep(2000);
		String test=driver.findElement(By.cssSelector("body")).getText();
		
		if(test.contains("You have reached your license maximum for this Product. Please contact LRS or visit www.lrsus.com for information on purchasing additional licenses."))
		{
			System.out.println("***********************************");
			System.out.println("user limit exceed");
			System.out.println("***********************************");
		}
		else{
			WebElement deviceName=driver.findElement(By.className("input-block-level"));
			deviceName.clear();
			deviceName.sendKeys(incrId +"Test1");
			Thread.sleep(10000);
driver.findElement(By.className("btn btn-primary saveBtn")).click();
Thread.sleep(5000);
System.out.println("Table Tracker module completed");
		}
		}
	
	
	 
	
}


