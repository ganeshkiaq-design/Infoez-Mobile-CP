package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

    @Before(order = 0)
    public void setUp() throws Exception {

        launchApplication();
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {

        closeApplication();
    }
}
