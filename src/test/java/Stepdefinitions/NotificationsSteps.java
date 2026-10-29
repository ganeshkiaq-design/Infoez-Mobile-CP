
package Stepdefinitions;

import driver.DriverSessionManager;
import pages.NotificationsPage;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class NotificationsSteps {

    AndroidDriver driver;
    NotificationsPage page;
    WebDriverWait wait;

    @Before(order = 1)
    public void initialize() {
        driver = (AndroidDriver) DriverSessionManager.getDriver();
        Assert.assertNotNull(driver, "Appium driver is null");
        page = new NotificationsPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @When("I open Notifications")
    public void openNotifications() {
        wait.until(ExpectedConditions.elementToBeClickable(
            page.notificationsButton)).click();
    }

    @Then("a notification item should be displayed")
    public void notificationDisplayed() {
        Assert.assertTrue(wait.until(
            ExpectedConditions.visibilityOf(page.notificationItem)
        ).isDisplayed());
    }
}
