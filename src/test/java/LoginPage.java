import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By usernameLocator = By.xpath("//input[@id='login-username']");
    private By passwordLocator = By.xpath("//input[@id='login-password']");
    private By loginPageLoginButtonLocator = By.xpath("//button[@id='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String username, String password) {
        //Login may fail if 2step verification popup comes up
        this.waitAndReturnElement(this.usernameLocator).sendKeys(username);
        this.waitAndReturnElement(this.passwordLocator).sendKeys(password);
        this.waitAndReturnElement(this.loginPageLoginButtonLocator).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.loginPageLoginButtonLocator));

        return new MainPage(this.driver);
    }

    public LoginPage loginExpectingFailure(String username, String password) {
        this.waitAndReturnElement(this.usernameLocator).sendKeys(username);
        this.waitAndReturnElement(this.passwordLocator).sendKeys(password);
        this.waitAndReturnElement(this.loginPageLoginButtonLocator).click();

        return this;
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("/login");
    }

}
