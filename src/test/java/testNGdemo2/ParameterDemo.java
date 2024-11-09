package testNGdemo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {
    WebDriver driver;

    @Test
    @Parameters("browser")
    public void launchBrowser(String browser) throws InterruptedException {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        driver.navigate().to("https://www.saucedemo.com/");
        Thread.sleep(5000);
        driver.quit();
    }
}
