package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest {

    WebDriver driver;

    LoginPage loginPage;
    LandingPage landingPage;

    @Test
    public void verifyLogin() {

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.gotToUrl("https://www.saucedemo.com/");
        loginPage.doLogin("standard_user", "secret_sauce");
        landingPage = new LandingPage(driver);
        boolean result = landingPage.isProductTextDisplayed();
        if (result) {
            System.out.println("login verification is success");
        } else {
            System.out.println("login verification is failed");

        }

        driver.quit();
    }
}
