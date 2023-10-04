package org.example.app.pages;

import io.appium.java_client.AppiumBy;
import org.example.app.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage extends BasePageObject {

    public String getTitle() {
        By locator = AppiumBy.xpath("//android.view.View[@content-desc=\"Calculator\"]");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        return element.getAttribute("content-desc");
    }

    public boolean historyBtnAppear() {
        return isDisplayed(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
    }

    public void tapFirstOperand() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"1\"]"));
    }

    public void tapPlusOperator() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\" + \"]"));
    }

    public void tapSecondOperand() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"2\"]"));
    }

    public void tapEqual() {
        click(AppiumBy.xpath("//android.view.View[@content-desc=\"=\"]"));
    }

    public int getResult(int result) {
        String res = Integer.toString(result);
        String resXpath = "(//android.view.View[@content-desc=\"5\"])[1]";

        String xpath = resXpath.replace("5", res);

        WebElement resultElement = find(AppiumBy.xpath(xpath));

        String calculationResult = resultElement.getAttribute("content-desc");

        return Integer.parseInt(calculationResult);
    }
}
