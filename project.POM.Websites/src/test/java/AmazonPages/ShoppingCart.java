package AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCart {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")
	WebElement cartButton;
	
	//*[@id="sc-active-7bd0f4a1-46f7-4a9f-a490-a3dc2f641b99"]/div[4]/div/div[3]/ul/div[1]/div[1]/div[1]/div/span/text()
	//*[@id="sc-active-abe8be1e-a0b2-40cb-856a-68b0e3d0a43d"]/div[4]/div/div[3]/ul/div[1]/div[1]/div[1]/div/span/text()
	@FindBy(xpath="//*[@id=\"sc-active-abe8be1e-a0b2-40cb-856a-68b0e3d0a43d\"]/div[4]/div/div[3]/ul/div[1]/div[1]/div[1]/div/span/text()")
	WebElement productPrice;
	private String actual= productPrice.getText();
	
	//*[@id="sc-subtotal-amount-activecart"]/span/text()
	@FindBy(xpath="//*[@id=\"sc-subtotal-amount-activecart\"]/span/text()")
	WebElement subTotal;
	
	public ShoppingCart(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setCartButton() throws Exception {
		Thread.sleep(5000);
		cartButton.click();
	}

	public void setSubTotal() {
		String subtotal=subTotal.getText();
		Assert.assertEquals(actual, subtotal,"Total miss match");
		
	}
}
