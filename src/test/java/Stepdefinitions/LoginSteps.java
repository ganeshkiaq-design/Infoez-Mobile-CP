package Stepdefinitions;

import driver.DriverSessionManager;
import pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Map;

public class LoginSteps {

    AndroidDriver driver;
    LoginPage page;
    WebDriverWait wait;

    @Given("the Infoez login screen is displayed")
    public void loginScreen() {

        driver = (AndroidDriver)
                DriverSessionManager.getDriver();

        Assert.assertNotNull(
            driver,
            "Appium driver is not initialized. Check Hooks."
        );

        page = new LoginPage(driver);

        wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(20)
        );

        Assert.assertTrue(
            wait.until(
                ExpectedConditions.visibilityOf(
                    page.loginButton
                )
            ).isDisplayed(),
            "Infoez login screen is not displayed"
        );
    }

   @When("I enter email {string} and password {string}")
    public void credentials(String email, String password) {

        String actualEmail = Map.of("valid_customer_email",ConfigReader.get("valid.customer.email")
        ).getOrDefault(email, email);

        String actualPassword = Map.of("valid_pass",ConfigReader.get("valid.customer.password"),"invalid_pass",
            "incorrect-password").getOrDefault(password, password);

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOf(page.emailField));

        emailInput.clear();
        emailInput.sendKeys(actualEmail);

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOf(page.passwordField));

        passwordInput.clear();
        passwordInput.sendKeys(actualPassword);
    }

    @When("I enter valid Infoez credentials")
    public void validCredentials() {

        wait.until(
            ExpectedConditions.visibilityOf(
                page.emailField
            )
        ).clear();

        page.emailField.sendKeys(
            ConfigReader.get("valid.customer.email")
        );

        wait.until(
            ExpectedConditions.visibilityOf(
                page.passwordField
            )
        ).clear();

        page.passwordField.sendKeys(
            ConfigReader.get("valid.customer.password")
        );
    }

    @When("I leave the login fields blank")
    public void blank() {

        wait.until(
            ExpectedConditions.visibilityOf(
                page.emailField
            )
        ).clear();

        wait.until(
            ExpectedConditions.visibilityOf(
                page.passwordField
            )
        ).clear();
    }

    @When("I tap the Login button")
    public void login() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.loginButton
            )
        ).click();
    }

    @Then("the Infoez Home or Explore screen should be displayed")
    public void home() {

        Assert.assertTrue(
            wait.until(
                ExpectedConditions.visibilityOf(
                    page.homeOrExploreIndicator
                )
            ).isDisplayed(),
            "Infoez Home or Explore screen is not displayed"
        );
    }

    @Then("a login validation error should be displayed")
    public void error() {

        Assert.assertTrue(
            wait.until(
                ExpectedConditions.visibilityOf(
                    page.errorLabel
                )
            ).isDisplayed(),
            "Login validation error is not displayed"
        );
    }
}
