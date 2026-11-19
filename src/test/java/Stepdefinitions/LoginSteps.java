package Stepdefinitions;

import java.util.Map;
import org.testng.Assert;
import base.BaseClass;
import driver.DeviceSessionManager;
import pages.LoginPage;
import utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {

    private LoginPage lp;
    private AndroidDriver getDriver() {
        return (AndroidDriver) DeviceSessionManager.getDriver();

    }
    private LoginPage getPage() {

        if (lp == null) {
            lp = new LoginPage(getDriver());
        }
        return lp;
    }
    @Given("the Infoez login screen is displayed")
    public void loginScreen() {
        Assert.assertNotNull(getDriver(),"Appium driver is not initialized. Check Hooks.");
        visibilityWait(getDriver(), getPage().loginButton);
        Assert.assertTrue(getPage().loginButton.isDisplayed(),
                "Infoez login screen is not displayed");
    }
    @When("I enter email {string} and password {string}")
    public void credentials(String email, String password) {
        String actualEmail = Map.of("valid_customer_email",
                ConfigReader.get("valid.customer.email")).getOrDefault(email, email);
        String actualPassword = Map.of("valid_pass",ConfigReader.get("valid.customer.password"),
                "invalid_pass", "incorrect-password").getOrDefault(password, password);
        visibilityWait(getDriver(), getPage().emailField);
        sendKeys(getDriver(), getPage().emailField, actualEmail);
        visibilityWait(getDriver(), getPage().passwordField);
        sendKeys(getDriver(), getPage().passwordField, actualPassword);

    }
    @When("I enter valid Infoez credentials")
    public void validCredentials() {
        visibilityWait(getDriver(), getPage().emailField);
        sendKeys(getDriver(), getPage().emailField,ConfigReader.get("valid.customer.email"));
        visibilityWait(getDriver(), getPage().passwordField);
        sendKeys(getDriver(),getPage().passwordField,ConfigReader.get("valid.customer.password"));

    }
    @When("I leave the login fields blank")
    public void blank() {

        visibilityWait(getDriver(), getPage().emailField);
        getPage().emailField.clear();
        getPage().passwordField.clear();

    }
    @When("I tap the Login button")
    public void login() {
        visibilityWait(getDriver(), getPage().loginButton);
        click(getDriver(), getPage().loginButton);
    }
    @Then("the Infoez Home or Explore screen should be displayed")
    public void home() {
        visibilityWait(getDriver(), getPage().homeOrExploreIndicator);
        Assert.assertTrue(getPage().homeOrExploreIndicator.isDisplayed(),
                "Infoez Home or Explore screen is not displayed");
    }

    @Then("a login validation error should be displayed")
    public void error() {
        visibilityWait(getDriver(), getPage().errorLabel);
        Assert.assertTrue(getPage().errorLabel.isDisplayed(),
                "Login validation error is not displayed");
    }
}
 