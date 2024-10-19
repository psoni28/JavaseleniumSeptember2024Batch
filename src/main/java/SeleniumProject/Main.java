package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        //List<WebElement> links = driver.findElements(By.xpath("//a"));
        //List<WebElement> links = driver.findElements(By.cssSelector("a"));
        for (WebElement link : links) {
            System.out.println("linkName: " + link.getText());
        }

        driver.quit();
    }
}