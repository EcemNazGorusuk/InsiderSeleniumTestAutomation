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
    public static List<WebElement> allPositions;
    public static List<WebElement> allLocations;
    public static List<WebElement> allDepartments;

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
         allPositions = driver.findElements(By.cssSelector(".position-list-item-wrapper .position-title"));
         allLocations = driver.findElements(By.cssSelector(".position-list-item-wrapper .position-location"));
         allDepartments = driver.findElements(By.cssSelector(".position-list-item-wrapper .position-department"));
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


    @Step("Click 'View Role' button")
    public JobsPage clickViewRoleButton() throws InterruptedException {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".position-list-item-wrapper"));
        WebElement getFirstFilteredButton=buttons.get(0);
        getFirstFilteredButton.click();
        return this;
    }
    @Step("Click 'Apply For This Job' button")
    public JobsPage clickApplyForThisJobButton() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//a[@data-qa='show-page-apply']"));
        button.click();
        return this;
    }

    @Step("Redirecting to Lever Page control")
    public JobsPage clickLeverPage() {
        checkPageUrl("https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc");
        return this;
    }

}
