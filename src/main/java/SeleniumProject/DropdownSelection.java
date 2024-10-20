package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropdownSelection {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        WebElement selectSimpleDropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(selectSimpleDropdown);
        Thread.sleep(2000);
        //select.selectByVisibleText("Option 2");
        //select.selectByIndex(1);
        select.selectByValue("2");
        Thread.sleep(2000);
        driver.quit();
    }
}