package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        //implicit wait is global wait
        // it is wait throught out life of the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        System.out.println("title : " + driver.getTitle());
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("mobile phone under 20000");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000); // dead wait for
        System.out.println("title : " + driver.getTitle());
        driver.quit();
    }
}