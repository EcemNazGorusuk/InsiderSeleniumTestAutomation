import Base.BaseTest;
import PageObjects.CareersPage;
import PageObjects.HomePage;
import PageObjects.JobsPage;
import org.testng.annotations.Test;

public class JobTests extends BaseTest {
    CareersPage careersPage=new CareersPage();
    JobsPage jobsPage=new JobsPage();

    @Test(description = "TC01 - Filter jobs by location and verify their existence")
    public void filterJobsByLocation() throws InterruptedException {
        careersPage.navigateToQAPage()
                   .checkQAPageTitle()
                   .checkQAPageUrl()
                   .clickSeeAllQAJobsButton();
        jobsPage.checkJobsPageTitle()
                .checkJobsPageUrl()
                .filterByLocation();
                //select filtre steplerini oluştur
                //filtrelenmiş öğenin varlığını kontrol et


    }
}
