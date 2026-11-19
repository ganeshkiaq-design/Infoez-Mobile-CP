package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Logoutpage {
   
	public AndroidDriver driver;
   public Logoutpage(AndroidDriver driver) {

	   this.driver = driver;
       PageFactory.initElements(driver, this);
       }
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
   public WebElement profile;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
   public WebElement logout;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log in or register\")")
   public WebElement register;
}