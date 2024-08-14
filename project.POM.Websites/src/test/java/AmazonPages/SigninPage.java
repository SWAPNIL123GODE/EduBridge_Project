package AmazonPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SigninPage {
  
	private WebDriver driver;
	
	@FindBy(xpath="/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]")
	WebElement hoverToSignIN;
	
//	@FindBy(xpath="/html/body/div[1]/header/div/div[3]/div[2]/div[2]/div/div[1]/div/a/span")
//	WebElement SignIn;
	
	//xpath="/html/body/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div/div/div/div[1]/input[1]"
	//xpath="//*[@id='ap_email']" //*[@id='ap_email' and @name='email']
	//css = "#ap_email" #ap_email
	//id = "ap_email"
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div/div/div/div[1]/input[1]")
	WebElement userIDtextfeild;
	
	@FindBy(xpath="//*[@id='continue']")
	WebElement ContinouButton;
	
	@FindBy(xpath="//*[@id='ap_password']")
	WebElement passwordtextfeild;
	
	@FindBy(xpath="//*[@id='signInSubmit']")
	WebElement SignInButton;
	
	@FindBy(xpath="//*[@id='nav-logo-sprites']")
	WebElement AmazonLogovalidation;
	
	public SigninPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setHoverToSignIN() throws Exception {
		
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions act = new Actions(driver);
		act.moveToElement(hoverToSignIN);
		hoverToSignIN.click();
	}

	public void setUserIDtextfeild(String userid) throws Exception {
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//userIDtextfeild.click();
		userIDtextfeild.sendKeys(userid);
	}

	public void setContinouButton() throws Exception {
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ContinouButton.click();
	}

	public void setPasswordtextfeild(String password) {
		passwordtextfeild.click();
		passwordtextfeild.sendKeys(password);
	}

	public void setSignInButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SignInButton.click();
	}
	
	public void LoginValidation() {
		Assert.assertTrue(AmazonLogovalidation.isDisplayed(), "Loging Succesfull");
	}
	
	
}
