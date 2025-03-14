package Base;
import PageObjects.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest  extends BaseLibrary{
   MainPage mainPage =new MainPage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(insiderUrl);
        mainPage.acceptAllCookies();
    }
    @AfterMethod
    public void tearDown(){
      driver.quit();
    }
}
