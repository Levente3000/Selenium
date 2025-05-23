import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbuseReportPage extends BasePage {
    private By abuseReportSelectLocator = By.xpath("//select[@id='ReportCategory']");
    private By otherRuleViolationOptionLocator = By.xpath("//option[@value='9']");
    private By commentTextAreaLocator = By.xpath("//textarea[@id='Comment']");

    public AbuseReportPage(WebDriver driver) {
        super(driver);
    }

    public AbuseReportPage sendForm() {
        this.waitAndReturnElement(this.abuseReportSelectLocator).click();
        this.waitAndReturnElement(this.otherRuleViolationOptionLocator).click();
        this.waitAndReturnElement(this.commentTextAreaLocator).sendKeys("Test Report");
        this.waitAndReturnElement(this.commentTextAreaLocator).submit();

        return this;
    }
}
