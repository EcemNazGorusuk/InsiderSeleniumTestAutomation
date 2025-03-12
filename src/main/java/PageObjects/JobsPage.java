package PageObjects;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobsPage extends BaseLibrary {
    @Step("Check Jobs Page Title")
    public JobsPage checkJobsPageTitle() {
        checkPageTitle(jobsPageTitle);
        return this;
    }

    @Step("Check Jobs Page Url")
    public JobsPage checkJobsPageUrl() {
        checkPageUrl(insiderUrl+"careers/open-positions/?department=qualityassurance");
        return this;
    }

    @Step("Filter by location")
    public JobsPage filterByLocation() throws InterruptedException {
        WebElement elementScroll = driver.findElement(By.id("career-position-filter"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementScroll);

        Thread.sleep(4000);
        WebElement dropdown = driver.findElement(By.id("filter-by-location"));

        // Select nesnesini oluşturuyoruz
        Select select = new Select(dropdown);

        // "Istanbul, Turkey" öğesini seçiyoruz
        select.selectByIndex(1);
        return this;
    }
}
