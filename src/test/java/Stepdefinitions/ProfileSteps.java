
package Stepdefinitions;

import base.BaseClass;
import driver.DeviceSessionManager;
import pages.ProfilePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class ProfileSteps {

    AndroidDriver driver;
    ProfilePage profilePage;

    @Before(order = 1)
    public void initializePages() {
        driver = (AndroidDriver) DeviceSessionManager.getDriver();
        Assert.assertNotNull(driver, "Android driver is not initialized");
        profilePage = new ProfilePage(driver);
    }

    // ---------------- EXPLORE BUSINESSES ----------------

    @When("user navigates to explore businesses")
    public void user_navigates_to_explore_businesses() {
        BaseClass.click(driver, profilePage.exploreBusinesses);
    }

    @When("user searches for business {string}")
    public void user_searches_for_business(String businessName) {
        BaseClass.sendKeys(driver, profilePage.businessSearchField, businessName);
        BaseClass.click(driver, profilePage.businessSearchButton);
    }

    @Then("business listing should be displayed")
    public void business_listing_should_be_displayed() {
        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, profilePage.businessSearchField),
                "Business listing is not displayed"
        );
    }

    @Then("business {string} should be available")
    public void business_should_be_available(String businessName) {
        try {
            String selector = "new UiSelector().text(\"" + businessName + "\")";
            WebElement businessElement =
                    driver.findElement(AppiumBy.androidUIAutomator(selector));

            Assert.assertTrue(
                    BaseClass.isElementDisplayed(driver, businessElement),
                    "Business not found: " + businessName
            );
        } catch (Exception e) {
            Assert.fail("Business element not found at all: " + businessName);
        }
    }

    @Then("no matching business should be displayed")
    public void no_matching_business_should_be_displayed() {
        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, profilePage.noBusinessMessage),
                "No-business-found message is not displayed"
        );
    }

    // ---------------- SAVED PLACES ----------------

    @When("user saves the business {string}")
    public void user_saves_the_business(String businessName) {
        BaseClass.click(driver, profilePage.addFavoriteButton);
    }

    @Given("business {string} is already saved")
    public void business_is_already_saved(String businessName) {
        BaseClass.click(driver, profilePage.exploreBusinesses);
        BaseClass.sendKeys(driver, profilePage.businessSearchField, businessName);
        BaseClass.click(driver, profilePage.businessSearchButton);

        try {
            String removeSelector =
                    "new UiSelector().description(\"Remove from favorites\")";

            WebElement removeBtn =
                    driver.findElement(AppiumBy.androidUIAutomator(removeSelector));

            if (!BaseClass.isElementDisplayed(driver, removeBtn)) {
                BaseClass.click(driver, profilePage.addFavoriteButton);
            }

        } catch (Exception e) {
            BaseClass.click(driver, profilePage.addFavoriteButton);
        }
    }

    @When("user navigates to saved places")
    public void user_navigates_to_saved_places() {
        BaseClass.click(driver, profilePage.savedPlaces);
    }

    @Then("saved business {string} should be displayed")
    public void saved_business_should_be_displayed(String businessName) {
        try {
            String selector = "new UiSelector().text(\"" + businessName + "\")";
            WebElement savedBusinessElement =
                    driver.findElement(AppiumBy.androidUIAutomator(selector));

            Assert.assertTrue(
                    BaseClass.isElementDisplayed(driver, savedBusinessElement),
                    "Saved business not found: " + businessName
            );

        } catch (Exception e) {
            Assert.fail("Saved business element missing: " + businessName);
        }
    }

    @When("user removes the saved business {string}")
    public void user_removes_the_saved_business(String businessName) {
        BaseClass.click(driver, profilePage.removeFavoriteButton);
    }

    @Then("saved business {string} should not be displayed")
    public void saved_business_should_not_be_displayed(String businessName) {
        try {
            String selector = "new UiSelector().text(\"" + businessName + "\")";
            WebElement element =
                    driver.findElement(AppiumBy.androidUIAutomator(selector));

            Assert.assertFalse(
                    BaseClass.isElementDisplayed(driver, element),
                    "Business is still present in Saved Places: " + businessName
            );

        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    // ---------------- NOTIFICATIONS ----------------

    @When("user navigates to notifications")
    public void user_navigates_to_notifications() {
        BaseClass.click(driver, profilePage.notifications);
    }

    @Then("notification {string} should be displayed")
    public void notification_should_be_displayed(String title) {
        try {
            String selector =
                    "new UiSelector().textContains(\"" + title + "\")";

            WebElement notifTitleElement =
                    driver.findElement(AppiumBy.androidUIAutomator(selector));

            Assert.assertTrue(
                    BaseClass.isElementDisplayed(driver, notifTitleElement),
                    "Notification not found: " + title
            );

        } catch (Exception e) {
            Assert.fail("Notification element not found: " + title);
        }
    }

    @Then("notification message should contain {string}")
    public void notification_message_should_contain(String message) {
        try {
            String selector =
                    "new UiSelector().textContains(\"" + message + "\")";

            WebElement notifMsgElement =
                    driver.findElement(AppiumBy.androidUIAutomator(selector));

            Assert.assertTrue(
                    BaseClass.isElementDisplayed(driver, notifMsgElement),
                    "Notification message not found: " + message
            );

        } catch (Exception e) {
            Assert.fail("Notification message element not found: " + message);
        }
    }

    @Then("notification {string} should not be displayed")
    public void notification_should_not_be_displayed(String title) {
        try {
            String selector =
                    "new UiSelector().textContains(\"" + title + "\")";

            WebElement notifElement =
                    driver.findElement(AppiumBy.androidUIAutomator(selector));

            Assert.assertFalse(
                    BaseClass.isElementDisplayed(driver, notifElement),
                    "Unexpected notification found: " + title
            );

        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    // ---------------- ENQUIRIES ----------------

    @When("user opens the first business result")
    public void user_opens_the_first_business_result() {
        BaseClass.click(driver, profilePage.businessResult);
    }

    @Then("the Business Details screen should be displayed")
    public void business_details_screen_should_be_displayed() {
        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, profilePage.enquiriesButton),
                "Business Details screen is not displayed"
        );
    }

    @When("user opens Enquiries")
    public void user_opens_enquiries() {
        BaseClass.click(driver, profilePage.enquiriesButton);
    }

    @When("user enters enquiry message {string}")
    public void user_enters_enquiry_message(String message) {
        if (message == null || message.trim().isEmpty()) {
            return;
        }

        BaseClass.sendKeys(driver, profilePage.enquiryMessageField, message);
    }

    @When("user submits the enquiry")
    public void user_submits_the_enquiry() {
        BaseClass.click(driver, profilePage.submitEnquiryButton);
    }

    @Then("the enquiry should be submitted successfully")
    public void enquiry_should_be_submitted_successfully() {
        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, profilePage.enquirySuccessMessage),
                "Enquiry success message is not displayed"
        );
    }

    @Then("an enquiry validation error should be displayed")
    public void enquiry_validation_error_should_be_displayed() {
        Assert.assertTrue(
                BaseClass.isElementDisplayed(driver, profilePage.enquiryValidationError),
                "Enquiry validation error is not displayed"
        );
    }
}
