package hooks;

import base.BaseClass;
import driver.DeviceSessionManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

    @Before
    public void setUp() throws Exception {

        if (!DeviceSessionManager.isDriverActive()) {

            System.out.println("===== Starting Mobile Devices =====");

            DeviceSessionManager.startDevices();

            System.out.println("===== All Devices Started =====");
        }
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {

        System.out.println("===== Closing Mobile Devices =====");

        AndroidDriver localDriver = DeviceSessionManager.getDriver();

        try {
            if (scenario.isFailed() && localDriver != null) {

                String deviceName = String.valueOf(
                    localDriver.getCapabilities()
                               .getCapability("appium:deviceName")
                );

                System.out.println("Failed Screenshot DeviceName: " + deviceName);

                BaseClass.takeScreenshot(
                    localDriver,
                    scenario,
                    "FAILED_" + deviceName
                );
            }

        } catch (Exception e) {

            System.out.println("Screenshot capture failed: " + e.getMessage());
            e.printStackTrace();

        } finally {

            DeviceSessionManager.quitDevice();

            System.out.println("===== All Devices Closed =====");
        }
    }
}
