package AmazonPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MangerAmazonProp {
 
	private WebDriver driver;
	private Properties prop;
	
	public WebDriver initialization() throws IOException 
	{
		
		prop= new Properties();
		String path="D:\\Eclipse_Workspaces\\EduBridge\\project.POM.Websites\\src\\test\\resources\\amazonprojectconfig.properties";
		FileInputStream fis= new FileInputStream(path);
		prop.load(fis);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;
	}
	
	public String getURL()
	{
		return prop.getProperty("url");
	}
	
	public String getusername()
	{
		return prop.getProperty("userId");
	}
	
	public String getpassword()
	{
		return prop.getProperty("password");
	}
}
