package AmazonPages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SerchItem {
	
private WebDriver driver;
private String expectedtext="Added to Cart";
	
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	WebElement serchFeild;
	
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a")
	WebElement product;
	
	@FindBy(css = ".a-section > #addToCart_feature_div #add-to-cart-button")
	WebElement addToCatButton;
	
	@FindBy(xpath="/html/body/div[8]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div[3]/div/span[2]/span/input")
	WebElement skipButton;

	@FindBy(xpath="#attach-sidesheet-checkout-button .a-button-input")
	WebElement proceedButton;
	
	@FindBy(xpath="//span[@id='attach-sidesheet-view-cart-button']/span/input")
	WebElement textValidate;
	
	public SerchItem(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public void javaScript() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	}
	
	public void setSerchFeild() {
		serchFeild.sendKeys("ASUS");
		serchFeild.sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,650)", "");
		product.click();
		
	}

	public void setAddToCatButton() throws Exception {
		
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator<String> itrate = windowhandle.iterator();
		String mainwindow = itrate.next();
		String childwindow = itrate.next();
		driver.switchTo().window(childwindow);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(8000);
		addToCatButton.click();
	}
	
	public void setTextValidate() {
		boolean actual =textValidate.isDisplayed();
		Assert.assertTrue(actual, "");
		//Assert.assertEquals(actual, expectedtext,"Product is not added to cart");
	}
}
