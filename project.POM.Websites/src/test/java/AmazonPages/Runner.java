package AmazonPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Runner {
	
	WebDriver driver;
	SigninPage signpage;
	LanguageSettingCheck langcheck;
	SerchItem serchitem;
	AddItemWishList addwishlist;
	ShoppingCart shopcart;
	MangerAmazonProp manger;
	
	@BeforeSuite
	 public void setup() throws IOException 
	{
		manger = new MangerAmazonProp();
		driver = manger.initialization();
		driver.get(manger.getURL());
	}
	
  @Test (priority=1)
  public void testvalidation1() throws Exception 
  {
	  signpage = new SigninPage(driver);
	  signpage.setHoverToSignIN();
	  signpage.setUserIDtextfeild(manger.getusername());
	  signpage.setContinouButton();
	  signpage.setPasswordtextfeild(manger.getpassword());
	  signpage.setSignInButton();
	  signpage.LoginValidation();
  }
  
  @Test (priority=2)
  public void testvalidation2() 
  {
	  langcheck = new LanguageSettingCheck(driver);
	  langcheck.setLangbutton();
	  langcheck.setRadiobutton();
	  langcheck.setActualtext();
	  langcheck.setHomebutton();
  }
  
  @Test (priority=3)
  public void testvalidation3() throws Exception 
  {
	  serchitem = new SerchItem(driver);
	  serchitem.setSerchFeild();
	  serchitem.setAddToCatButton();
	  serchitem.setTextValidate();
  }
  
  @Test (priority=4)
  public void testvalidation4() throws Exception 
  {
	  shopcart = new ShoppingCart(driver);
	  shopcart.setCartButton();
	  shopcart.setSubTotal();
  }
  
  @Test (priority=5)
  public void testvalidation5() 
  {
	  addwishlist = new AddItemWishList(driver);
	  addwishlist.setSaveLaterButton();
	  addwishlist.setCartEmpty();
  }
  
//  @AfterSuite
//  public void teardown()
//  {
//	  driver.quit();
//  }
}
