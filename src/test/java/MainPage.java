import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private By mainPageLoginButtonLocator = By.xpath("//a[contains(@class, 'rbx-navbar-login')]");
    private By cookieButtonLocator = By.xpath("//button[@class='btn-cta-lg cookie-btn btn-primary-md btn-min-width']");
    private By settingsButtonLocator = By.xpath("//button[@class='btn-navigation-nav-settings-md']");
    private By logoutMenuItemLocator = By.xpath("//a[@class='rbx-menu-item logout-menu-item']");
    private By filterLocator = By.xpath("//button[@class='filter-select btn-secondary-md btn-min-width']");
    private By profileMenuLocator = By.xpath("//a[@id='nav-profile']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public void navigateToPublicMainPage() {
        this.driver.get("https://www.roblox.com/charts#/?device=computer&country=all");
    }

    public LoginPage login() {
        this.waitAndReturnElement(this.cookieButtonLocator).click();
        this.waitAndReturnElement(this.mainPageLoginButtonLocator).click();

        return new LoginPage(this.driver);
    }

    public MainPage logout() {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(this.settingsButtonLocator));
        this.waitAndReturnElementWithTimout(this.settingsButtonLocator, 20).click();
        this.waitAndReturnElement(this.logoutMenuItemLocator).click();

        return this;
    }

    public boolean isSettingButtonVisible() {
        return this.waitAndReturnElement(this.filterLocator).isDisplayed();
    }

    public WebElement getFilterButtonElement() {
        return this.waitAndReturnElement(this.filterLocator);
    }

    public boolean isLoginButtonVisible() {
        return this.waitAndReturnElement(this.mainPageLoginButtonLocator).isDisplayed();
    }

    public ProfilePage navigateToProfilePage() {
        this.waitAndReturnElementWithTimout(this.profileMenuLocator, 20).click();

        return new ProfilePage(driver);
    }
}
