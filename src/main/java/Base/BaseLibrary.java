package Base;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.time.Duration;

public class BaseLibrary extends Data{
    public static WebDriver driver;

    public void sleepThread(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void switchTab(){
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
