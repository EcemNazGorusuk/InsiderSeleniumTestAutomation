package PageObjects;
import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage extends BaseLibrary {

    @Step("Check Careers Page Title")
    public CareersPage checkCareersPageTitle() {
        checkPageTitle(careersPageTitle);
        return this;
    }

    @Step("Check Careers Page Url")
    public CareersPage checkCareersPageUrl() {
        checkPageUrl(insiderUrl+"careers/");
        return this;
    }

    @Step("Check if 'Our Locations' section is displayed correctly")
    public CareersPage checkOurLocationsSection() {
        WebElement ourLocationSection = driver.findElement(By.id("career-our-location"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ourLocationSection);

        WebElement element = driver.findElement(By.xpath("//h3[normalize-space()='Our Locations']"));
        String actualText=element.getText();

        if(element.isDisplayed()){
            Assert.assertEquals("Our Locations", actualText);
        }
        return this;
    }

    @Step("Check if 'Our Locations' slider is displayed properly")
    public CareersPage checkOurLocationsSlider() {
        WebElement ourLocationSection = driver.findElement(By.cssSelector("div[class='col-12 d-flex flex-wrap']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ourLocationSection);

        WebElement element = driver.findElement(By.cssSelector(".glide__slide.glide__slide--active"));
        if(element.isDisplayed()){
            String getFirstText=element.getText();
            Assert.assertEquals("New York\nUS", getFirstText);
            System.out.println(getFirstText);
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        return this;
    }

    @Step("Check if 'Life at Insider' Section is displayed properly")
    public CareersPage checkLifeAtInsiderSection() {
        WebElement sectionElement = driver.findElement(By.cssSelector("[data-id='a8e7b90']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", sectionElement);

        WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Life at Insider']"));
        if(element.isDisplayed()){
            String getTitleText = element.getText();
            Assert.assertEquals("Life at Insider", getTitleText);
            System.out.println(getTitleText);
        }
        return this;
    }

    @Step("Check if 'See All Teams' button works correctly")
    public CareersPage checkSeeAllTeamsButton() {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'See all teams')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return this;
    }

    @Step("Navigate to 'https://useinsider.com/careers/quality-assurance/'")
    public CareersPage navigateToQAPage(){
        String qaPageUrl = insiderUrl+"careers/quality-assurance/";
        driver.navigate().to(qaPageUrl);
        return this;
    }

    @Step("Check QA Page Title")
    public CareersPage checkQAPageTitle() {
        checkPageTitle(qaPageTitle);
        return this;
    }

    @Step("Check QA Page Url")
    public CareersPage checkQAPageUrl() {
        checkPageUrl(insiderUrl+"careers/quality-assurance/");
        return this;
    }

    @Step("Click 'See All QA Jobs' button")
    public CareersPage clickSeeAllQAJobsButton() {
        WebElement seeAllQAJobsButton = driver.findElement(By.xpath("//a[normalize-space()='See all QA jobs']"));
        seeAllQAJobsButton.click();
        return this;
   
   }

}
