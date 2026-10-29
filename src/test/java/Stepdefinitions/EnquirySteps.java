
package Stepdefinitions;

import driver.DriverSessionManager;
import pages.EnquiryPage;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import java.time.Duration;

public class EnquirySteps {

    AndroidDriver driver;
    EnquiryPage page;
    WebDriverWait wait;

    // INITIALIZE ENQUIRY PAGE

    @Before(order = 1)
    public void initialize() {

        driver = (AndroidDriver)
                DriverSessionManager.getDriver();

        Assert.assertNotNull(
            driver,
            "Appium driver is not initialized. Check Hooks."
        );

        page = new EnquiryPage(driver);

        wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(20)
        );
    }

    // OPEN ENQUIRIES

    @When("I open Enquiries")
    public void openEnquiries() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.enquiriesButton
            )
        ).click();
    }

    // ENTER ENQUIRY MESSAGE

    @When("I enter enquiry message {string}")
    public void enterMessage(String message) {

        WebElement field = wait.until(
            ExpectedConditions.visibilityOf(
                page.messageField
            )
        );

        field.clear();
        field.sendKeys(message);
    }

    // SUBMIT ENQUIRY

    @When("I submit the enquiry")
    public void submitEnquiry() {

        wait.until(
            ExpectedConditions.elementToBeClickable(
                page.submitButton
            )
        ).click();
    }

    // VERIFY SUCCESSFUL ENQUIRY

    @Then("the enquiry should be submitted successfully")
    public void enquirySuccess() {

        Assert.assertTrue(
            wait.until(
                ExpectedConditions.visibilityOf(
                    page.successMessage
                )
            ).isDisplayed(),
            "Enquiry success message is not displayed"
        );
    }

    // VERIFY ENQUIRY VALIDATION ERROR

    @Then("an enquiry validation error should be displayed")
    public void enquiryError() {

        Assert.assertTrue(
            wait.until(
                ExpectedConditions.visibilityOf(
                    page.validationError
                )
            ).isDisplayed(),
            "Enquiry validation error is not displayed"
        );
    }
}
