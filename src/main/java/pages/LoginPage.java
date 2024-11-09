package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    By userNameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginbButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void gotToUrl(String url) {
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public void doLogin(String userId, String pwd) {
        driver.findElement(userNameInput).sendKeys(userId);
        driver.findElement(passwordInput).sendKeys(pwd);
        driver.findElement(loginbButton).click();
    }

}
