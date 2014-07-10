package ForgotPassword;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class RunXMLByBatch {
	
	public void runXML() throws IOException
	{
//		System.out.println("inside runXML:::" + L2);
		
		//System.out.println("inside runXML:::" + L);
		
		String appendName="ExecuteLRSConnect.XML";
		
		//write into batch file
		String file_Path="LRSFile.bat";
		File file=new File(file_Path);

		try {
		 if (file.createNewFile()){
		     System.out.println("File is created!");
		   }
		 else{
		     System.out.println("File already exists.");
		   }
		} catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		}

		PrintWriter writer = new PrintWriter(file_Path, "UTF-8");
		writer.println("Set ProjectPath=F:\\java projects\\LRS1.1");
		writer.println("Set classpath=%ProjectPath%\\bin;C:\\Users\\sunnyk\\Downloads\\selenium-java-2.40.0\\selenium-java-2.40.0\\selenium-2.40.0\\libs\\*;C:\\Users\\sunnyk\\Downloads\\selenium-java-2.40.0\\selenium-java-2.40.0\\selenium-2.40.0\\*");
		writer.println("java org.testng.TestNG %ProjectPath%\\src\\LRS\\"+appendName);
		writer.close();
		
		
		Runtime rt=Runtime.getRuntime();
		
		rt.exec(new String[]{"cmd", "/k", "start", "LRSFile.bat"});
		
	}
	
	public static void main(String[] args) throws Exception {
		
	RunXMLByBatch run=new RunXMLByBatch();
	run.runXML();
	
	}
}
