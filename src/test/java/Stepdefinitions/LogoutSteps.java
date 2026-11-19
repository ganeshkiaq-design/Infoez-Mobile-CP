package Stepdefinitions;

import org.testng.Assert;
import base.BaseClass;
import driver.DeviceSessionManager;
import pages.Logoutpage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps extends BaseClass {

	private Logoutpage lp;
	private AndroidDriver getDriver() {

		return (AndroidDriver) DeviceSessionManager.getDriver();
	}
	private Logoutpage getPage() {
		if (lp == null) {
			lp = new Logoutpage(getDriver());
		}
		return lp;
	}
	@Given("the admin tap on profile")
	public void the_admin_tap_on_profile() {
		Assert.assertNotNull(getDriver(), "Appium driver is not initialized. Check Hooks.");
		visibilityWait(getDriver(), getPage().profile);
		click(getDriver(), getPage().profile);
	}
	@When("the admin tap logout button")
	public void the_admin_tap_logout_button() {
		visibilityWait(getDriver(), getPage().logout);
		click(getDriver(), getPage().logout);

	}
	@Then("the admin validate the logout")
	public void the_admin_validate_the_logout() {
		visibilityWait(getDriver(), getPage().register);
		Assert.assertTrue(getPage().register.isDisplayed(),
				"Logout failed: Register element is not displayed");

	}
}
 