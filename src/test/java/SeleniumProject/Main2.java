package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        //implicit wait is global wait
        // it is wait throught out life of the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        System.out.println("title : " + driver.getTitle());
        //WebElement link = driver.findElement(By.("Electronics"));
        WebElement link = driver.findElement(By.partialLinkText("Kitchen"));
        link.click();
        System.out.println("title : " + driver.getTitle());
        driver.quit();
    }
}