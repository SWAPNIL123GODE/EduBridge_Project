package AmazonPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LanguageSettingCheck {
  
WebDriver driver;

private String expectedtext ="अनुवाद\n"
		+ "हम आपकी ब्राउज़िंग, खरीदारी और कम्युनिकेशन के लिए सबसे ज़रूरी जानकारी का अनुवाद करेंगे. हमारे अनुवाद आपकी सहूलियत के लिए प्रदान किए जाते हैं. हमारी उपयोग की शर्तों सहित Amazon.in का अंग्रेज़ी वर्जन ही अंतिम वर्जन है. और जानें";
	
//*[@id=\"icp-nav-flyout\"]/span
	@FindBy(xpath="//*[@id='icp-nav-flyout']")
	WebElement langbutton;
//*[@class='a-row a-spacing-mini']/div/label/i	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/form/div[1]/div[1]/div[3]/div/label/i")
	WebElement radiobutton;
	
	@FindBy(xpath="//*[@id='icp-language-disclaimer']")
	WebElement actualtext;
	
	@FindBy(xpath="//*[@id='nav-logo-sprites']")
	WebElement homebutton;
	

	public LanguageSettingCheck(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setLangbutton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		langbutton.click();
	}

	public void setRadiobutton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		radiobutton.click();
	}
	
	public void setActualtext() {
		String actual=actualtext.getText();
		Assert.assertEquals(actual, expectedtext, "Text Language is not selected");
	}
	
	public void setHomebutton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homebutton.click();
	}

}
