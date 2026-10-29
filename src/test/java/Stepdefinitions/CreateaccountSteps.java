package Stepdefinitions;

import driver.DriverSessionManager;
import pages.Createaccountpage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.Duration;

public class CreateaccountSteps {

    AndroidDriver driver;
    Createaccountpage page;
    WebDriverWait wait;

    @Given("the Infoez create account screen is displayed")
    public void createAccountScreenDisplayed() {

        driver = (AndroidDriver)DriverSessionManager.getDriver();

        Assert.assertNotNull(driver,"Appium driver is not initialized");

        page = new Createaccountpage(driver);

        wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(page.fullNameInput)
            ).isDisplayed(),"Create account screen is not displayed");
    }

    @Then("the create account screen should be visible")
    public void verifyCreateAccountScreen() {

        Assert.assertTrue(page.fullNameInput.isDisplayed());
        Assert.assertTrue(page.emailInput.isDisplayed());
        Assert.assertTrue(page.passwordInput.isDisplayed());
        Assert.assertTrue(page.createAccountButton.isDisplayed());
    }

    @When("I select the Customer account type")
    public void selectCustomerAccount() {

        wait.until(ExpectedConditions.elementToBeClickable(page.customerOption)).click();
    }
   @Then("the Customer account type should be selected")
    public void verifyCustomerSelected() {

        Assert.assertTrue(page.customerOption.isSelected(),"Customer account type is not selected");
    }
    @When("I enter full name {string}")
    public void enterFullName(String name) {

        wait.until(ExpectedConditions.visibilityOf(page.fullNameInput)).clear();
        page.fullNameInput.sendKeys("ganesh");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {

        wait.until(ExpectedConditions.visibilityOf(page.emailInput)).clear();
        page.emailInput.sendKeys("customer@gmail.com");
    }

    @When("I enter password {string}")
    public void enterPassword(String password) {

        wait.until(ExpectedConditions.visibilityOf(page.passwordInput)).clear();
        page.passwordInput.sendKeys("Customer@123");
    }

    @When("I click the Create account button")
    public void clickCreateAccount() {

        wait.until(ExpectedConditions.elementToBeClickable(page.createAccountButton)).click();
    }

    @Then("the customer account should be created successfully")
    public void verifyCustomerRegistration() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(page.registrationSuccessMessage)).isDisplayed(),"Customer registration was not successful");
    }

    @Then("the registration validation should be displayed")
    public void verifyRegistrationValidation() {

        Assert.assertTrue(wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(page.invalidEmailMessage),
                    ExpectedConditions.visibilityOf(page.shortPasswordMessage))),"Registration validation message not displayed");
    }

   @When("I click the Log in tab")
    public void clickLoginTab() {

        wait.until(ExpectedConditions.elementToBeClickable(page.loginTab)).click();
    }

    @Then("the login screen should be displayed")
    public void verifyLoginScreen() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(page.loginScreenTitle)).isDisplayed(),
            "Login screen is not displayed");
    }
    @When("I click the {string} demo account")
    public void clickCustomerDemo(String demoType) {

        Assert.assertEquals(demoType,"Customer","Unsupported demo account");

        wait.until(ExpectedConditions.elementToBeClickable(page.customerDemoButton)).click();
    }

    @Then("the customer demo account should be opened")
    public void verifyCustomerDemo() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(page.customerDemoHome)).isDisplayed(),"Customer demo home screen not displayed");
    }

   @When("I click the close button")
    public void clickCloseButton() {

        wait.until(ExpectedConditions.elementToBeClickable(page.closeButton)).click();
    }

    @Then("the create account screen should be closed")
    public void verifyCreateAccountClosed() {

        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(page.fullNameInput)),
            "Create account screen is still displayed");
    }
}
