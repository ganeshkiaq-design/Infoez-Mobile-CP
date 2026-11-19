# Infoez Appium Java Cucumber Project — corrected framework

## Requirements
- JDK 21, Maven, Android SDK/ADB, Appium 2 with UiAutomator2 driver, running emulator or Android device.
- The Infoez APK or installed Infoez app. APK is NOT included in this archive.

## Before executing
1. Run `adb devices` and confirm the device is online.
2. Find the actual Infoez package/activity (e.g. `adb shell dumpsys window | grep mCurrentFocus` while the app is open, or inspect the APK with aapt).
3. Edit `src/test/resources/config.properties`: replace `app.package` and `app.activity`; set `app.path` if installing APK, otherwise leave `none`. Set `device.udid` if multiple devices.
4. Set environment variables `INFOEZ_VALID_EMAIL` and `INFOEZ_VALID_PASSWORD`, or pass Maven `-Dvalid.email=... -Dvalid.password=...`.
5. Check **all** page locators using Appium Inspector; several are unverified, and `LoginPage` has assumed home/error IDs.
6. Start Appium: `appium`.
7. Run `mvn clean test` in the CP directory, or run `runner.TestRunner` as TestNG in Eclipse.
8. Inspect `target/cucumber-report.html`, `target/cucumber.json`, and `target/surefire-reports`.

## Important limitations
This ZIP fixes framework setup issues, but cannot guarantee passed scenarios. Live execution was not possible here; real app package/activity, valid credentials, app UI locators, test data and app behavior must be verified. Do not change assertions simply to force a green result.
