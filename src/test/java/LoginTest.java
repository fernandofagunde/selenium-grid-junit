
import java.net.URL;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest {

	@Description("Valida login com usuário válido no Chrome")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Fernando")
    @Test
    public void loginChrome() throws Exception {

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444"),
                options);

        executarTeste(driver);
    }

	@Description("Valida login com usuário válido no Firefox")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Fernando")
    @Test
    public void loginFirefox() throws Exception {

        FirefoxOptions options = new FirefoxOptions();

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444"),
                options);

        executarTeste(driver);
    }

   // @Test
    public void loginSafari() throws Exception {

        SafariOptions options = new SafariOptions();

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444"),
                options);

        executarTeste(driver);
    }

    public void executarTeste(WebDriver driver) throws Exception {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement username =
                driver.findElement(By.id("username"));

        WebElement password =
                driver.findElement(By.id("password"));

        WebElement submit =
                driver.findElement(By.id("submit"));

        username.sendKeys("student");

        password.sendKeys("Password123");

        submit.click();

        System.out.println("Título da página: "
                + driver.getTitle());

        Thread.sleep(3000);

        driver.quit();
    }
}