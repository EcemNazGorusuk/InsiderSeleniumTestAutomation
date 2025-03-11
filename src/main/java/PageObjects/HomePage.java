package PageObjects;
import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertTrue;

public class HomePage extends BaseLibrary {

    @Step("Check Home Page Title")
    public HomePage checkHomePageTitle() {
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle,homePageTitle );
        return this;
    }

    @Step("Check Home Page Url")
    public HomePage checkHomePageUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url: "+currentUrl);
        Assert.assertEquals(expectedUrl, currentUrl);
        if (!currentUrl.equals(expectedUrl)) {
            Assert.fail(wrongUrlMsg + currentUrl);
        }
        return this;
    }

    @Step("Check Insider Icon Button")
    public HomePage checkInsiderIconButton(){
        waitForElementToBeVisible(By.cssSelector("img[alt='insider_logo']"));
        WebElement element=driver.findElement(By.cssSelector("img[alt='insider_logo']"));
        assertTrue(element.isDisplayed());
        return this;
    }

    @Step("Click 'Company' dropdown button and navigate to Careers Page")
    public HomePage clickCompanyDropdownBtn(){
        WebElement dropdownBtn = driver.findElement(By.xpath("(//a[normalize-space()='Company'])[1]"));
        dropdownBtn.click();
        WebElement careersBtn = driver.findElement(By.xpath("(//a[normalize-space()='Careers'])[1]"));
        careersBtn.click();
        return this;
    }

}
