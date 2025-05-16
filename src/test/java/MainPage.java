import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private By mainPageLoginButtonLocator = By.xpath("//a[contains(@class, 'rbx-navbar-login')]");
    private By cookieButtonLocator = By.xpath("//button[contains(@class, 'btn-cta-lg')]");
    private By settingsButtonLocator = By.xpath("//button[contains(@class,'btn-navigation-nav-settings-md')]");
    private By logoutMenuItemLocator = By.xpath("//a[contains(@class,'logout-menu-item')]");
    private By profileMenuLocator = By.xpath("//a[contains(@href,'https://www.roblox.com/users/8475812665/profile')]");

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
        this.waitAndReturnElement(this.settingsButtonLocator).click();
        this.waitAndReturnElement(this.logoutMenuItemLocator).click();

        return this;
    }

    public boolean isSettingButtonVisible() {
        return this.waitAndReturnElement(this.settingsButtonLocator).isDisplayed();
    }

    public WebElement getSettingButtonElement() {
        return this.waitAndReturnElement(this.settingsButtonLocator);
    }

    public boolean isLoginButtonVisible() {
        return this.waitAndReturnElement(this.mainPageLoginButtonLocator).isDisplayed();
    }

    public ProfilePage navigateToProfilePage() {
        this.waitAndReturnElement(this.profileMenuLocator).click();

        return new ProfilePage(driver);
    }
}
