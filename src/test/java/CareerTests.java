import Base.BaseTest;
import PageObjects.CareersPage;
import PageObjects.HomePage;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Feature("Careers Testing Scenarios")
public class CareerTests extends BaseTest {
    HomePage homePage=new HomePage();
    CareersPage careersPage=new CareersPage();

    @Test(description ="TC01 - 'Careers Page' redirection control")
    public void verifyCareersPageIsOpen() throws InterruptedException {
        homePage.clickCompanyDropdownBtn();
        waitForElementToBeVisible(By.cssSelector("section[id='page-head'] div[class='container']"));
        careersPage.checkCareersPageTitle()
                   .checkCareersPageUrl("https://useinsider.com/careers/");
    }

    @Test(description ="TC02 - Check if 'Careers Page' and its 'Our Locations' are presented correctly")
    public void checkLocations() throws InterruptedException {
        homePage.clickCompanyDropdownBtn();
        waitForElementToBeVisible(By.cssSelector("section[id='page-head'] div[class='container']"));
        careersPage.checkOurLocationsSection()
                   .checkOurLocationsSlider();
    }

    @Test(description ="TC03 - Check if 'Careers Page' and its 'Teams' are presented correctly")
    public void checkTeams() throws InterruptedException {
        homePage.clickCompanyDropdownBtn();
        waitForElementToBeVisible(By.cssSelector("section[id='page-head'] div[class='container']"));
        careersPage.checkSeeAllTeamsButton();
    }

    @Test(description ="TC04 - Check if 'Careers Page' and its 'Life at Insider' section are presented correctly")
    public void checkLifeAtInsiderSection() throws InterruptedException {
        homePage.clickCompanyDropdownBtn();
        waitForElementToBeVisible(By.cssSelector("section[id='page-head'] div[class='container']"));
        careersPage.checkLifeAtInsiderSection();
    }
}
