import Base.BaseTest;
import PageObjects.CareersPage;
import PageObjects.HomePage;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Feature("Career Testing Scenarios")
public class CareerTests extends BaseTest {
    HomePage homePage=new HomePage();
    CareersPage careersPage=new CareersPage();

    @Test(description ="TC01 - Check if 'Careers Page' and its sections are presented correctly")
    public void checkCareersPagePresentedCorrectly() throws InterruptedException {
        homePage.clickCompanyDropdownBtn();
        waitForElementToBeVisible(By.cssSelector("section[id='page-head'] div[class='container']"));
        careersPage.checkCareersPageTitle()
                   .checkCareersPageUrl("https://useinsider.com/careers/")
                   .checkOurLocationsSection()
                   .checkOurLocationsSlider();
    }
}
