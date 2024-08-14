package AmazonPages;

import java.io.File;
import java.nio.file.Files;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AmozaonListener implements ITestListener{
	
	WebDriver driver = new ChromeDriver();

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Started sucessfully the menthod"+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Finised sucessfully the menthod"+context.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Sucessfully Completed"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Date obj = new Date();
		String date = obj.toString().replace(" ","-").replace(":","-");
		File f= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Files.copy(f, new File("D:\\Eclipse_Workspaces\\EduBridge\\project.POM.Websites\\Screenshots"+date+".jpg"));
	}
	
	
	
 
}
