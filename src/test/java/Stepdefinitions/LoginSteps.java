package Stepdefinitions;

import base.BaseClass;
import driver.DeviceSessionManager;
import pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.ConfigReader;
import java.util.Map;

public class LoginSteps {
   AndroidDriver driver;
   LoginPage page;
   @Given("the Infoez login screen is displayed")
   public void loginScreen() {
       driver = (AndroidDriver) DeviceSessionManager.getDriver();
       Assert.assertNotNull(
           driver,
           "Appium driver is not initialized. Check Hooks."
       );
       page = new LoginPage(driver);
       Assert.assertTrue(
           BaseClass.isElementDisplayed(driver, page.loginButton),
           "Infoez login screen is not displayed"
       );
   }
   @When("I enter email {string} and password {string}")
   public void credentials(String email, String password) {
       String actualEmail = Map.of(
           "valid_customer_email",
           ConfigReader.get("valid.customer.email")
       ).getOrDefault(email, email);
       String actualPassword = Map.of(
           "valid_pass",
           ConfigReader.get("valid.customer.password"),
           "invalid_pass",
           "incorrect-password"
       ).getOrDefault(password, password);
       BaseClass.sendKeys(driver, page.emailField, actualEmail);
       BaseClass.sendKeys(driver, page.passwordField, actualPassword);
   }
   @When("I enter valid Infoez credentials")
   public void validCredentials() {
       BaseClass.sendKeys(
           driver,
           page.emailField,
           ConfigReader.get("valid.customer.email")
       );
       BaseClass.sendKeys(
           driver,
           page.passwordField,
           ConfigReader.get("valid.customer.password")
       );
   }
   @When("I leave the login fields blank")
   public void blank() {
       page.emailField.clear();
       page.passwordField.clear();
   }
   @When("I tap the Login button")
   public void login() {
       BaseClass.click(driver, page.loginButton);
   }
   @Then("the Infoez Home or Explore screen should be displayed")
   public void home() {
       Assert.assertTrue(
           BaseClass.isElementDisplayed(driver, page.homeOrExploreIndicator),
           "Infoez Home or Explore screen is not displayed"
       );
   }
   @Then("a login validation error should be displayed")
   public void error() {
       Assert.assertTrue(
           BaseClass.isElementDisplayed(driver, page.errorLabel),
           "Login validation error is not displayed"
       );
   }
}