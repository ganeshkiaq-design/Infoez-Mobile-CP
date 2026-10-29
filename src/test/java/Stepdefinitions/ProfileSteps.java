
package Stepdefinitions;

import driver.DriverSessionManager;
import pages.ProfilePage;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class ProfileSteps {

    AndroidDriver driver;
    ProfilePage page;
    WebDriverWait wait;

    @Before(order = 1)
    public void initialize() {
        driver = (AndroidDriver) DriverSessionManager.getDriver();
        Assert.assertNotNull(driver, "Appium driver is null");
        page = new ProfilePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @When("the user navigates to the Profile page")
    public void navigateProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(
            page.profileTab)).click();
        Assert.assertTrue(wait.until(
            ExpectedConditions.visibilityOf(page.profileHeading)
        ).isDisplayed());
    }

    @When("I open Profile")
    public void openProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(
            page.profileTab)).click();
    }

    @Then("the Profile screen should be displayed")
    public void profileScreen() {
        Assert.assertTrue(wait.until(
            ExpectedConditions.visibilityOf(page.profileHeading)
        ).isDisplayed());
    }

    @Then("the Explore businesses option should be displayed")
    public void exploreOption() {
        Assert.assertTrue(page.exploreBusinesses.isDisplayed());
    }

    @Then("the Saved places option should be displayed")
    public void savedOption() {
        Assert.assertTrue(page.savedPlaces.isDisplayed());
    }

    @Then("the My enquiries option should be displayed")
    public void enquiriesOption() {
        Assert.assertTrue(page.myEnquiries.isDisplayed());
    }

    @Then("the Notifications option should be displayed")
    public void notificationsOption() {
        Assert.assertTrue(page.notifications.isDisplayed());
    }

    @When("the user taps Explore businesses")
    public void tapExplore() {
        page.exploreBusinesses.click();
    }

    @When("the user taps Saved places")
    public void tapSaved() {
        page.savedPlaces.click();
    }

    @When("the user taps My enquiries")
    public void tapEnquiries() {
        page.myEnquiries.click();
    }

    @When("the user taps Notifications")
    public void tapNotifications() {
        page.notifications.click();
    }

    @Then("the profile Explore businesses page should be displayed")
    public void exploreDestination() {
        Assert.assertTrue(page.exploreDestination.isDisplayed());
    }

    @Then("the profile Saved places page should be displayed")
    public void savedDestination() {
        Assert.assertTrue(page.savedDestination.isDisplayed());
    }

    @Then("the profile My enquiries page should be displayed")
    public void enquiriesDestination() {
        Assert.assertTrue(page.enquiriesDestination.isDisplayed());
    }

    @Then("the profile Notifications page should be displayed")
    public void notificationsDestination() {
        Assert.assertTrue(page.notificationsDestination.isDisplayed());
    }

    @Then("the Home navigation should be displayed")
    public void homeNavigation() {
        Assert.assertTrue(page.homeTab.isDisplayed());
    }

    @Then("the Search navigation should be displayed")
    public void searchNavigation() {
        Assert.assertTrue(page.searchTab.isDisplayed());
    }

    @Then("the Saved navigation should be displayed")
    public void savedNavigation() {
        Assert.assertTrue(page.savedTab.isDisplayed());
    }

    @Then("the Profile navigation should be displayed")
    public void profileNavigation() {
        Assert.assertTrue(page.profileTab.isDisplayed());
    }

    @When("the user taps the Logout icon")
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(
            page.logoutButton)).click();
    }

    @Then("the logout confirmation or login page should be displayed")
    public void logoutResult() {
        Assert.assertTrue(wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOf(page.logoutConfirmation),
            ExpectedConditions.visibilityOf(page.loginScreen)
        )));
    }
}
