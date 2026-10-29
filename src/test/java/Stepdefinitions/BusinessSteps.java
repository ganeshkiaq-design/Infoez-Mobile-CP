
package Stepdefinitions;

import driver.DriverSessionManager;
import pages.BusinessPage;

import io.appium.java_client.android.AndroidDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import java.time.Duration;

public class BusinessSteps {

    AndroidDriver driver;
    BusinessPage page;
    WebDriverWait wait;

    // =====================================
    // INITIALIZE BUSINESS PAGE
    // =====================================

    @Before(order = 1)
    public void initialize() {

        driver = (AndroidDriver)
                DriverSessionManager.getDriver();

        Assert.assertNotNull(
            driver,
            "Appium driver is not initialized. Check Hooks."
        );

        page = new BusinessPage(driver);

        wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(20)
        );
    }

    // =====================================
    // VERIFY BUSINESS DETAILS
    // =====================================

    @Then("the Business Details screen should be displayed")
    public void businessDetails() {

        Assert.assertTrue(
            wait.until(
                ExpectedConditions.visibilityOf(
                    page.businessDetails
                )
            ).isDisplayed(),
            "Business Details screen is not displayed"
        );
    }

    // =====================================
    // TAP CALL
    // =====================================

    @When("I tap Call")
    public void tapCall() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.callButton
            )
        ).click();
    }

    // =====================================
    // TAP WHATSAPP
    // =====================================

    @When("I tap WhatsApp")
    public void tapWhatsApp() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.whatsAppButton
            )
        ).click();
    }

    // =====================================
    // TAP DIRECTIONS
    // =====================================

    @When("I tap Directions")
    public void tapDirections() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.directionsButton
            )
        ).click();
    }

    // =====================================
    // TAP SHARE
    // =====================================

    @When("I tap Share")
    public void tapShare() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.shareButton
            )
        ).click();
    }
}
