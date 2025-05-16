import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private By abuseReportLinkLocator = By.xpath("//a[contains(@class,'abuse-report-link')]");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public AbuseReportPage navigateToAbuseReportPage() {
        this.waitAndReturnElement(this.abuseReportLinkLocator).click();

        return new AbuseReportPage(driver);
    }
}
