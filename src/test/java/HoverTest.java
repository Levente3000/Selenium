import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class HoverTest {
    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void testSettingsButtonHover() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.navigateToPublicMainPage();
        LoginPage loginPage = mainPage.login();
        MainPage mainPageAfterLogin = loginPage.login("SeleniumUserName", "SeleniumPassword");

        WebElement FilterButton = mainPageAfterLogin.getFilterButtonElement();
        String colorBefore = FilterButton.getCssValue("background-color");

        Actions actions = new Actions(driver);
        actions.moveToElement(FilterButton).perform();

        String colorAfter = FilterButton.getCssValue("background-color");

        Assert.assertNotEquals(colorBefore, colorAfter);
    }
}
