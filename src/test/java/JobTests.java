import Base.BaseTest;
import PageObjects.CareersPage;
import PageObjects.HomePage;
import PageObjects.JobsPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Jobs Testing Scenarios")
public class JobTests extends BaseTest {
    CareersPage careersPage=new CareersPage();
    JobsPage jobsPage=new JobsPage();

    @Test(description = "TC01 -Filter Jobs by Location & Department,Verify and Navigate to the Lever Application Page via View Button")
    public void filterJobsByLocation() throws InterruptedException {
        careersPage.navigateToQAPage()
                   .checkQAPageTitle()
                   .checkQAPageUrl()
                   .clickSeeAllQAJobsButton();
        jobsPage.checkJobsPageTitle()
                .checkJobsPageUrl()
                .filterByLocationAndDepartment()
                .checkPresenceOfFilters()
                .clickViewRoleButton()
                .clickApplyForThisJobButton();




    }
}
