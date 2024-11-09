package factoryTestcases;

import factoryPages.LandingPage;
import factoryPages.LoginPage;
import factoryPages.YourCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LoginTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    WebDriver driver;

    LoginPage loginPage;
    LandingPage landingPage;
    YourCartPage yourCartPage;

    @Test
    public void VerifyAddToCart() {

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

        landingPage.performAddToCart();
        landingPage.goToCart();
        yourCartPage= new YourCartPage(driver);
        yourCartPage.perFormContinueShopping();

        result = landingPage.isProductTextDisplayed();
        if (result) {
            System.out.println("redirection from  your car to landing is success");
        } else {
            System.out.println("redirection from  your car to landing is failed");
        }
    }
}