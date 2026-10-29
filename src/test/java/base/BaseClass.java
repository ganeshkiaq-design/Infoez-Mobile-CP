package base;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass {

    public static AppiumDriver getDriver() {

        return DriverFactory.getDriver();
    }
    public void launchApplication() throws Exception {

        DriverFactory.createDriver();
    }
    public void closeApplication() {

        DriverFactory.quitDriver();
    }
    public byte[] takeScreenshot() {

        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
