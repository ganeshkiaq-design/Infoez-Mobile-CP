package Stepdefinitions;

import base.BaseClass;
import driver.DeviceSessionManager;
import pages.Createaccountpage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CreateaccountSteps {

    AndroidDriver driver;
    Createaccountpage page;

    @Given("the Infoez create account screen is displayed")
    public void createAccountScreenDisplayed() {

        driver = (AndroidDriver) DeviceSessionManager.getDriver();

        Assert.assertNotNull(
                driver,
                "Appium driver is not initialized");

        page = new Createaccountpage(driver);

        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, page.fullNameInput),
                "Create account screen is not displayed");
    }

    @Then("the create account screen should be visible")
    public void verifyCreateAccountScreen() {

        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, page.fullNameInput),
                "Full name field is not displayed");

        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, page.emailInput),
                "Email field is not displayed");

        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, page.passwordInput),
                "Password field is not displayed");

        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, page.createAccountButton),
                "Create account button is not displayed");
    }

    @When("I select the Customer account type")
    public void selectCustomerAccount() {

        BaseClass.click(driver, page.customerOption);
    }

    @Then("the Customer account type should be selected")
    public void verifyCustomerSelected() {

        Assert.assertTrue(
                BaseClass.isElementSelected(driver, page.customerOption),
                "Customer account type is not selected");
    }

    @When("I enter full name {string}")
    public void enterFullName(String name) {

        BaseClass.sendKeys(driver, page.fullNameInput, name);
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {

        BaseClass.sendKeys(driver, page.emailInput, email);
    }

    @When("I enter password {string}")
    public void enterPassword(String password) {

        BaseClass.sendKeys(driver, page.passwordInput, password);
    }

    @When("I click the Create account button")
    public void clickCreateAccount() {

        BaseClass.click(driver, page.createAccountButton);
    }

    @Then("the customer account should be created successfully")
    public void verifyCustomerRegistration() {

        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, page.registrationSuccessMessage),
                "Customer registration was not successful");
    }

    @Then("the registration validation should be displayed")
    public void verifyRegistrationValidation() {
       Assert.assertTrue(
           BaseClass.isAnyElementDisplayed(
               driver,
               page.invalidEmailMessage,
               page.shortPasswordMessage,
               page.requiredFieldMessage
           ),
           "Registration validation message not displayed"
       );
    }

    @When("I click the Log in tab")
    public void clickLoginTab() {

        BaseClass.click(driver, page.loginTab);
    }

    @Then("the login screen should be displayed")
    public void verifyLoginScreen() {

        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, page.loginScreenTitle),
                "Login screen is not displayed");
    }

    @When("I click the {string} demo account")
    public void clickCustomerDemo(String demoType) {

        Assert.assertEquals(
                demoType,
                "Customer",
                "Unsupported demo account");

        BaseClass.click(driver, page.customerDemoButton);
    }

    @Then("the customer demo account should be opened")
    public void verifyCustomerDemo() {

        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, page.customerDemoHome),
                "Customer demo home screen not displayed");
    }

    @When("I click the close button")
    public void clickCloseButton() {

        BaseClass.click(driver, page.closeButton);
    }

    @Then("the create account screen should be closed")
    public void verifyCreateAccountClosed() {

        Assert.assertTrue(
                BaseClass.isElementInvisible(driver, page.fullNameInput),
                "Create account screen is still displayed");
    }
}
