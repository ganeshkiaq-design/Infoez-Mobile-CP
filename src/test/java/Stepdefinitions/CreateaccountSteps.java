package Stepdefinitions;

import org.testng.Assert;
import base.BaseClass;
import driver.DeviceSessionManager;
import pages.Createaccountpage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateaccountSteps extends BaseClass {
   
	Createaccountpage lp;
   
	private AndroidDriver getAndroidDriver() {
       return (AndroidDriver) DeviceSessionManager.getDriver();
   }
   
	@Given("the user launch the application")
   public void the_user_launch_the_application() {
       lp = new Createaccountpage(getAndroidDriver());
       relaunchApp(getAndroidDriver());
   }
   
	@When("the user taps the create account card")
   public void tapCreateAccountCard() {
       visibilityWait(getAndroidDriver(), lp.createAccountCard);
       click(getAndroidDriver(), lp.createAccountCard);
       visibilityWait(getAndroidDriver(), lp.fullNameInput);
       Assert.assertTrue(lp.fullNameInput.isDisplayed(),
               "Create account screen is not displayed"
       );
   }
   
   @When("the user enters a fullname {string}")
   public void enterFullName(String name) {
       visibilityWait(getAndroidDriver(), lp.fullNameInput);
       sendKeys(getAndroidDriver(), lp.fullNameInput, name);
   }
   
   @When("the user enters an email {string}")
   public void enterEmail(String email) {
       visibilityWait(getAndroidDriver(), lp.emailInput);
       sendKeys(getAndroidDriver(), lp.emailInput, email);
   }
   
   @When("the user enters a password {string}")
   public void enterPassword(String password) {
       visibilityWait(getAndroidDriver(), lp.passwordInput);
       sendKeys(getAndroidDriver(), lp.passwordInput, password);
   }
   @When("the user taps on the create account button")
   public void clickCreateAccount() {
       visibilityWait(getAndroidDriver(), lp.createAccountButton);
       click(getAndroidDriver(), lp.createAccountButton);
   }
   @Then("the account creation result should be {string}")
   public void verifyHomePageRedirection(String expected) {
       switch (expected.toLowerCase()) {
       case "valid":
           visibilityWait(getAndroidDriver(), lp.homePageElement);
           String actual = gettext(getAndroidDriver(), lp.homePageElement);
           Assert.assertTrue(lp.homePageElement.isDisplayed());
           System.out.println(actual);
           break;
       case "invalid1":
           String actual1 = gettext(getAndroidDriver(), lp.invalidEmailMessage);
           Assert.assertTrue(lp.invalidEmailMessage.isDisplayed());
           System.out.println(actual1);
           break;
       case "invalid2":
           String actual2 = gettext(getAndroidDriver(), lp.shortPasswordMessage);
           Assert.assertTrue(lp.shortPasswordMessage.isDisplayed());
           System.out.println(actual2);
           break;
       case "invalid3":
           String actual3 = gettext(getAndroidDriver(), lp.requiredFieldMessage);
           Assert.assertTrue(lp.requiredFieldMessage.isDisplayed());
           System.out.println(actual3);
           break;
       case "invalid4":
           String actual4 = gettext(getAndroidDriver(), lp.invalidNameMessage);
           Assert.assertTrue(lp.invalidNameMessage.isDisplayed());
           System.out.println(actual4);
           break;
       case "invalid5":
           String actual5 = gettext(getAndroidDriver(), lp.registrationErrorMessage);
           Assert.assertTrue(lp.registrationErrorMessage.isDisplayed());
           System.out.println(actual5);
           break;
       default:
           Assert.fail("Invalid expected result: " + expected);
       }
   }
}