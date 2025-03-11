package PageObjects;
import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CareersPage extends BaseLibrary {

    @Step("Check Careers Page Title")
    public CareersPage checkCareersPageTitle() {
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle,careersPageTitle );
        return this;
    }

    @Step("Check Careers Page Url")
    public CareersPage checkCareersPageUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url: "+currentUrl);
        Assert.assertEquals(expectedUrl, currentUrl);
        if (!currentUrl.equals(expectedUrl)) {
            Assert.fail(wrongUrlMsg + currentUrl);
        }
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
        //.col-12.mt-3.mt-md-5.pt-md-5
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
}
