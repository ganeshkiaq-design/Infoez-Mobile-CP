package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.support.PageFactory;

public class Createaccountpage {

	public AndroidDriver driver;
    public Createaccountpage(AndroidDriver driver) {
    
    	this.driver = driver;
       PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
   }
   @AndroidFindBy(uiAutomator = "new UiSelector().description(\", Profile\")")
   public WebElement profileButton;
  
   @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Log in or register\")")
   public WebElement loginOrRegisterButton;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create account\").instance(0)")
   public WebElement createAccountCard;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"register-name\")")
   public WebElement fullNameInput;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login-email\")")
   public WebElement emailInput;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login-password\")")
   public WebElement passwordInput;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create account\").instance(1)")
   public WebElement createAccountButton;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Infoez\")")
   public WebElement homePageElement;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please fill every field.\")")
   public WebElement invalidNameMessage;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please fill every field.\")")
   public WebElement requiredFieldMessage;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter a valid email address.\")")
   public WebElement invalidEmailMessage;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter a valid email address.\")")
   public WebElement invalidEmailFormatMessage;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password must be at least 8 characters.\")")
   public WebElement shortPasswordMessage;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Email already registered\")")
   public WebElement invalidNameValidation;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Email already registered\")")
   public WebElement invalidNumericName;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Email already registered\")")
   public WebElement registrationErrorMessage;
   
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Infoez\")")
   public WebElement registrationSuccessMessage;
}