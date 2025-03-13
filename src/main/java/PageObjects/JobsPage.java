package PageObjects;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Step("Filter by Location & Department")
    public JobsPage filterByLocationAndDepartment() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement elementScroll = driver.findElement(By.id("career-position-filter"));
        js.executeScript("arguments[0].scrollIntoView(true);", elementScroll);
        WebElement dropdownDepartment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//span[@id='select2-filter-by-department-container']")));
        WebElement dropdownLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//span[@id='select2-filter-by-location-container']")));
        if(dropdownDepartment.isDisplayed()) {
            Thread.sleep(7000);
            dropdownLocation.click();
            WebElement dropdownSelectLocation =driver.findElement(By.cssSelector("ul#select2-filter-by-location-results > li:nth-of-type(2)"))  ;
            Thread.sleep(7000);
            dropdownSelectLocation.click();
        }
        return this;
    }

    @Step("Check the presence of filtered Locations & Department")
    public JobsPage checkPresenceOfFilters() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> allPositions = driver.findElements(By.cssSelector(".position-list-item-wrapper .position-title"));
        List<WebElement> allLocations = driver.findElements(By.cssSelector(".position-list-item-wrapper .position-location"));
        List<WebElement> allDepartments = driver.findElements(By.cssSelector(".position-list-item-wrapper .position-department"));
        String expectedPosition="Quality Assurance";
        String expectedLocation="Istanbul, Turkiye";
        String expectedDepartment="Quality Assurance";
        ArrayList<String> results = new ArrayList<String>();
            for (WebElement position : allPositions) {
                //Assert.assertTrue(position.getText().contains(expectedPosition)));
                if (!position.getText().contains(expectedPosition))
                {
                    results.add("Expected : " + expectedPosition + " Actual : " + position.getText());
                }
            }
            
            for (WebElement location : allLocations) {
                //Assert.assertEquals(expectedLocation,location.getText());
                if (!location.getText().equals(expectedLocation))
                {
                    results.add("Expected : " + expectedLocation + " Actual : " + location.getText());
                }
            }
            for (WebElement department : allDepartments) {
                //Assert.assertEquals(expectedDepartment, department.getText());
                if (!department.getText().equals(expectedDepartment))
                {
                    results.add("Expected : " + expectedDepartment + " Actual : " + department.getText());
                }
            }
        if (!results.isEmpty()) {
            System.out.println("ERRORS...!");
            for (String result : results) {
                System.out.println(result);
            }
        }
        return this;
    }


    @Step("Check the presence of filtered Locations & Department")
    public JobsPage example() throws InterruptedException {
        return this;
    }

}
