import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private By abuseReportLinkLocator = By.xpath("//a[@class='abuse-report-link abuse-report-modal']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public AbuseReportPage navigateToAbuseReportPage() {
        this.waitAndReturnElement(this.abuseReportLinkLocator).click();

        return new AbuseReportPage(driver);
    }
}
