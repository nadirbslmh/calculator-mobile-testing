package org.example.hooks;

import io.cucumber.java.*;
import org.example.app.drivers.AndroidDriverInit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AndroidDriverHook {
    @Before(value = "@android")
    public void beforeScenario() {
        AndroidDriverInit.initialize();
    }

    @After(value = "@android")
    public void afterScenario(Scenario scenario) {
        AndroidDriverInit.quit();
    }

    @BeforeStep
    public void beforeStep() {}

    @AfterStep
    public void afterStep(Scenario scenario) {
        TakesScreenshot screenshot = AndroidDriverInit.driver;
        byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(imageByte, "image/png", scenario.getId());
    }
}
