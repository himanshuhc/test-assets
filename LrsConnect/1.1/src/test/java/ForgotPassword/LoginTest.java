package ForgotPassword;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.Reader;

public class LoginTest extends Functions{
	
	Reader read=new Reader();
	private static HSSFSheet ExcelWSheet;
    private static HSSFWorkbook ExcelWBook;
    private static HSSFCell Cell;
    @Test(dataProvider = "Testdata")
  public void Login(String Username, String password) throws InterruptedException {
	  	
	  System.out.println("Username"+Username+"Password"+password);
	  	driver.findElement(By.cssSelector("*[id='j_username']")).sendKeys(
				Username);
	  	Thread.sleep(2000);
		driver.findElement(By.id("j_password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("btnLoginSubmit")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.cssSelector("*[id='j_username']")).clear();
		
		driver.findElement(By.id("j_password")).clear();
		Thread.sleep(2000);
 }
	
    @DataProvider
   public static Object[][] Testdata() throws Exception{
    	
    	Object[][] tabArray = null;
	 File excel = new File("LRSLoginSheet.xls");
         FileInputStream ExcelFile = new FileInputStream(excel);
         // Access the required test data sheet
         ExcelWBook = new HSSFWorkbook(ExcelFile);
         ExcelWSheet = ExcelWBook.getSheet("Sheet1");

         int startRow = 1;
         int startCol = 1;
         int ci,cj;
         int totalRows = ExcelWSheet.getLastRowNum();
         // you can write a function as well to get Column count
         int totalCols = ExcelWSheet.getRow(0).getLastCellNum();;

         tabArray=new String[totalRows][totalCols];
         ci=0;
         for (int i=startRow;i<=totalRows;i++, ci++) {                 
            cj=0;
             for (int j=startCol;j<=totalCols;j++, cj++){
            	  Cell = ExcelWSheet.getRow(ci+1).getCell(cj);
                  
                  String CellData = Cell.getStringCellValue();
                
                 tabArray[ci][cj]=CellData;
                 System.out.println(tabArray[ci][cj]);  
                  }
              }
          
     
      return(tabArray);
      }

      
 
  }
   

