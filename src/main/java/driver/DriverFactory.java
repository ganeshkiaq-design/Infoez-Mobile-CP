
package driver;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public final class DriverFactory {

    private DriverFactory() {
    }
    public static AndroidDriver createDriver(
            String deviceName,
            String udid,
            String appiumUrl,
            int systemPort,
            String appPackage,
            String appActivity) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName(deviceName);
        options.setUdid(udid);
        options.setAutomationName("UiAutomator2");
        options.setSystemPort(systemPort);
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);
        options.setAutoGrantPermissions(true);
        options.setNewCommandTimeout(java.time.Duration.ofSeconds(3600));
        options.setCapability("appium:adbExecTimeout", 120000);
        options.setCapability("appium:uiautomator2ServerLaunchTimeout", 120000);

        AndroidDriver driver = new AndroidDriver(
                new URL(appiumUrl),
                options
        );

        System.out.println("Infoez application launched successfully");
        System.out.println("Device Name: " + deviceName);
        System.out.println("Session ID: " + driver.getSessionId());

        return driver;
    }
}