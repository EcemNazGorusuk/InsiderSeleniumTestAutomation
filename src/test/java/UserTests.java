import Base.BaseTest;
import PageObjects.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("User Testing Scenarios")
public class UserTests extends BaseTest {
    HomePage homePage=new HomePage();

    @Test(description = "TC01 - Homepage redirection control")
    public void verifyHomePageIsOpen() throws InterruptedException {
        homePage.checkHomePageUrl("https://useinsider.com/")
                .checkHomePageTitle()
                .checkInsiderIconButton();
    }
}
