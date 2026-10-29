package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static void createDriver() throws Exception {

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName(ConfigReader.get("device.name"));
        options.setPlatformVersion(ConfigReader.get("platform.version"));
        Path apk = Paths.get(ConfigReader.get("app.path")).toAbsolutePath().normalize();
        System.out.println("APK Path: " + apk);
        options.setApp(apk.toString());
        options.setAppPackage(ConfigReader.get("app.package"));
        options.setAppActivity(ConfigReader.get("app.activity"));
        options.setNoReset(ConfigReader.getBoolean("app.noReset"));
        options.setAutoGrantPermissions(true);
        options.setNewCommandTimeout(Duration.ofSeconds(3600));
        options.setCapability("appium:adbExecTimeout",120000);
        options.setCapability("appium:uiautomator2ServerLaunchTimeout",120000);

        AndroidDriver driver = new AndroidDriver(URI.create(ConfigReader.get("appium.url")).toURL(), options);
        DriverSessionManager.setDriver(driver);
        System.out.println("Infoez application launched successfully");
        System.out.println("Session ID: " + driver.getSessionId());
    }

     public static AndroidDriver getDriver() {
        return (AndroidDriver)
                DriverSessionManager.getDriver();
    }

     public static void quitDriver() {

        DriverSessionManager.getDriver().quit();

        DriverSessionManager.removeDriver();
    }
}
