package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseLibrary {

    @Step("Cookie Notification Acceptance Control")
    public MainPage acceptAllCookiesButton() throws InterruptedException {
        sleepThread(4000);
        WebElement element=driver.findElement(By.cssSelector("#wt-cli-accept-all-btn"));
        if(element.isDisplayed())
            driver.findElement(By.cssSelector("#wt-cli-accept-all-btn")).click();
        return this;
    }
}
