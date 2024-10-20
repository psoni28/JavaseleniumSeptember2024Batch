package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(System.getProperty("user.dir")+"\\src\\test\\resources\\mutipleSelectDropdown.html");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        WebElement selectCars = driver.findElement(By.id("cars"));
        Select select = new Select(selectCars);
        System.out.println(select.isMultiple());
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Saab");
        select.selectByVisibleText("Opel");
        select.selectByVisibleText("Scoda");
        Thread.sleep(3000);
        select.deselectAll();
        Thread.sleep(3000);
        driver.quit();
    }
}