package AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemWishList {
	
	WebDriver driver;
	private String expectedtext=" Your Amazon Cart is empty.";

	@FindBy(xpath="//*[@id='sc-active-7bd0f4a1-46f7-4a9f-a490-a3dc2f641b99']/div[4]/div/div[3]/div[1]/span[3]/span/input")
	WebElement saveLaterButton;	
	
	@FindBy(xpath="")
	WebElement cartEmpty;

	public AddItemWishList(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setSaveLaterButton() {
		saveLaterButton.click();
	}

	public void setCartEmpty() {
		String actual = cartEmpty.getText();
		
		Assert.assertEquals(actual, expectedtext,"Cart is not Empty");
	}
	
	
}
