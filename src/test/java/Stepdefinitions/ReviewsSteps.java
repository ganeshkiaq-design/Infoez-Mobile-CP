package Stepdefinitions;

import driver.DriverSessionManager;
import pages.ReviewsPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.Duration;

public class ReviewsSteps {

    AndroidDriver driver;
    ReviewsPage page;
    WebDriverWait wait;

    @Before(order = 1)
    public void initialize() {
        driver = (AndroidDriver) DriverSessionManager.getDriver();
        Assert.assertNotNull(driver, "Appium driver is null");
        page = new ReviewsPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @When("I open Reviews")
    public void openReviews() {
        wait.until(ExpectedConditions.elementToBeClickable(
            page.reviewsButton)).click();
    }

    @When("I select rating 1")
    public void rating1() {
        page.rating1.click();
    }

    @When("I select rating 2")
    public void rating2() {
        page.rating2.click();
    }

    @When("I select rating 3")
    public void rating3() {
        page.rating3.click();
    }

    @When("I select rating 4")
    public void rating4() {
        page.rating4.click();
    }

    @When("I select rating 5")
    public void rating5() {
        page.rating5.click();
    }

    @When("I enter review {string}")
    public void enterReview(String review) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOf(page.reviewField)
        );
        field.clear();
        field.sendKeys(review);
    }

    @When("I submit the review")
    public void submitReview() {
        wait.until(ExpectedConditions.elementToBeClickable(
            page.submitReviewButton)).click();
    }

    @Then("the review should be submitted successfully")
    public void reviewSuccess() {
        Assert.assertTrue(wait.until(
            ExpectedConditions.visibilityOf(page.reviewSuccess)
        ).isDisplayed());
    }

    @Then("review validation should be displayed")
    public void reviewError() {
        Assert.assertTrue(wait.until(
            ExpectedConditions.visibilityOf(page.validationError)
        ).isDisplayed());
    }
}
